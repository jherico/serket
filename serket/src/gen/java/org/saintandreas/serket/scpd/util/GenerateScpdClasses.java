package org.saintandreas.serket.scpd.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.xpath.XPathExpressionException;

import org.saintandreas.serket.soap.SOAPSerializable;
import org.saintandreas.util.XPathUtil;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JBlock;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldVar;
import com.sun.codemodel.JForLoop;
import com.sun.codemodel.JInvocation;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import com.sun.codemodel.writer.FileCodeWriter;

public class GenerateScpdClasses {

    private final static String URI_PREFIX = "urn:schemas-upnp-org:service:";

    public static void main(String[] args) throws JClassAlreadyExistsException, IOException, XPathExpressionException, SAXException, ParserConfigurationException {
        JCodeModel cm = new JCodeModel();

        JPackage pkg = cm._package("org.saintandreas.serket.scpd");
        File scpdDir = new File("src/main/resources/scpd");
        File[] dirs = scpdDir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".xml");
            }
        });
        for (File f : dirs) {
            String serviceName = f.getName();//"ContentDirectory3";
            serviceName = serviceName.substring(0, serviceName.length() - 4);
            Document scpdDoc = XmlUtil.parseXmlFile(f);
            JDefinedClass cls = pkg._class(JMod.PUBLIC, serviceName, ClassType.INTERFACE);

            
            // public static final String URI = "urn:schemas-upnp-org:service:ContentDirectory:1";
            {
                String uriServiceName = serviceName;
                String uriVersionNumber = "1";
                if (Character.isDigit(serviceName.charAt(serviceName.length() - 1))) {
                    uriVersionNumber = serviceName.substring(serviceName.length() - 1);
                    uriServiceName = serviceName.substring(0, serviceName.length() - 1);
                }
                cls.field(JMod.STATIC | JMod.PUBLIC | JMod.FINAL, String.class, "URI").init(JExpr.lit(URI_PREFIX + uriServiceName + ":" + uriVersionNumber));
            }
            for (Element e : XPathUtil.getElements(scpdDoc, "/scpd/actionList/action")) {
                createAction(cm, cls, e);
            }
            //            for (Element e : XPathUtil.getElements(scpdDoc, "/scpd/serviceStateTable/stateVariable")) {
            //                createField(cls, e);
            //            }
        }

        File dest = new File("src/main/java/");
        dest.mkdirs();
        cm.build(new FileCodeWriter(dest));
    }

    private static void createAction(JCodeModel cm, JDefinedClass cls, Element e) throws XPathExpressionException, JClassAlreadyExistsException {
        String name = XPathUtil.getStringValue(e, "name").trim();
        String methodName = name.substring(0, 1).toLowerCase() + name.substring(1);
        Element[] outArgs = XPathUtil.getElements(e, "argumentList/argument[direction='out']");
        Element[] inArgs = XPathUtil.getElements(e, "argumentList/argument[direction='in']");
        JType returnType = getArgumentsType(cm, cls, name, outArgs, true);
        JType inputType = getArgumentsType(cm, cls, name, inArgs, false);
        JMethod method = cls.method(JMod.PUBLIC, returnType, methodName);
        if (inputType != cm.VOID) {
            method.param(inputType, "input");
        }
    }

    private static JType getArgumentsType(JCodeModel cm, JDefinedClass cls, String name, Element[] args, boolean out) throws XPathExpressionException, JClassAlreadyExistsException {
        JDefinedClass returnClass = cls._class(JMod.PUBLIC | JMod.STATIC | JMod.ABSTRACT, name + (out ? "Response" : "Request"));
        returnClass._extends(SOAPSerializable.class);

        // public void parse(SOAPMessage soapmessage) throws SOAPException;
        JMethod parse = returnClass.method(JMod.PUBLIC, cm.VOID, "parse");
        JVar soapMessageParam = parse.param(SOAPMessage.class, "soapMessage");

        // public SOAPMessage format()
        JMethod format = returnClass.method(JMod.PUBLIC, SOAPMessage.class, "format");
        format._throws(SOAPException.class);
        JVar formatRetVal = format.body().decl(cm.ref(SOAPMessage.class), "retVal").init(returnClass.staticInvoke("createMessage"));
        JInvocation formatBodyElementInvocation = formatRetVal.invoke("getSOAPBody").invoke("addBodyElement").arg(JExpr._new(cm.ref(QName.class)).arg(JExpr.ref("URI")).arg(JExpr.lit(returnClass.name())).arg(JExpr.lit("u")));

        if (args.length > 0) {
            parse.annotate(SuppressWarnings.class).param("value", "unchecked");
            parse._throws(SOAPException.class);
            JVar parseItr = parse.body().decl(cm.ref(Iterator.class), "itr", soapMessageParam.invoke("getSOAPBody").invoke("getChildElements"));;
            JForLoop parseFor = parse.body()._for();
            parseFor.test(parseItr.invoke("hasNext"));
            JVar parseForElement = parseFor.body().decl(cm.ref(Element.class), "e", JExpr.cast(cm.ref(Element.class), parseItr.invoke("next")));
            JVar parseForName = parseFor.body().decl(cm.ref(String.class), "name", parseForElement.invoke("getNodeName"));
            JVar formatElement = format.body().decl(cm.ref(SOAPBodyElement.class), "soapBodyElement",formatBodyElementInvocation);   
            // Element e = itr.next();
            // String name = e.getNodeName();
            for (Element outArg : args) {

                String relatedStateVariable = XPathUtil.getStringValue(outArg, "relatedStateVariable").trim();
                String elementName = XPathUtil.getStringValue(outArg, "name").trim(); 
                String fieldName = Character.toLowerCase(elementName.charAt(0)) + elementName.substring(1);
                JType fieldType = getStateVariableType(cm, cls, relatedStateVariable, outArg.getOwnerDocument());
                JFieldVar fieldVar = returnClass.field(JMod.PUBLIC, fieldType, fieldName);
                
                // element.addChildElement("Result").setTextContent(resultDidl);
                JInvocation formatSetText = formatElement.invoke("addChildElement").arg(JExpr.lit(elementName)).invoke("setTextContent");
                format.body().add(formatSetText);
                // if ("Result".equals(name)) {
                JBlock ifBody = parseFor.body()._if(JExpr.lit(fieldName).invoke("equals").arg(parseForName))._then();
                // String value = e.getTextContent();
                if (fieldType.isPrimitive()) {
                    formatSetText.arg(cm.ref(Integer.class).staticInvoke("toString").arg(fieldVar));
                } else {
                    formatSetText.arg(fieldVar.invoke("toString"));
                }
                
                if (fieldType.equals(cm.ref(String.class))) {
                    // TransferID = e.getTextContent();
                    ifBody.assign(fieldVar, parseForElement.invoke("getTextContent"));
                } else if (fieldType.equals(cm.ref(Integer.class)) || fieldType.equals(cm.INT)) {
                    // TransferID = Integer.valueOf(e.getTextContent());
                    ifBody.assign(fieldVar, cm.ref(Integer.class).staticInvoke("valueOf").arg(parseForElement.invoke("getTextContent")));
                } else if (fieldType.equals(cm.ref(Boolean.class)) || fieldType.equals(cm.BOOLEAN)) {
                    // TransferID = Integer.valueOf(e.getTextContent());
                    ifBody.assign(fieldVar, cm.ref(Boolean.class).staticInvoke("valueOf").arg(parseForElement.invoke("getTextContent")));
                } else if (fieldType instanceof JClass) {
                    JClass fieldCls = (JClass) fieldType;
                    // TransferStatus = org.saintandreas.serket.scpd.TransferStatus.valueOf(e.getTextContent());
                    ifBody.assign(fieldVar, fieldCls.staticInvoke("valueOf").arg(parseForElement.invoke("getTextContent")));
                } else {
                    System.out.println("unparsed type " + fieldType);
                }
                //            JVar value = ifBody.decl(cm.ref(String.class), "value", );
                ifBody._continue();
            }
        } else {
            format.body().add(formatBodyElementInvocation);
        }
        
        format.body()._return(formatRetVal);
        return returnClass;
    }

    private static JType getStateVariableType(JCodeModel cm, JDefinedClass ownerClass, String stateVariable, Document document) throws XPathExpressionException {
        Node originalVariable = XPathUtil.getNode(document, "/scpd/serviceStateTable/stateVariable[contains(name, '" + stateVariable + "')]");
        if (originalVariable == null) {
            String xpath = "/scpd/serviceStateTable/stateVariable[contains(name, '" + stateVariable + "')]";
            originalVariable = XPathUtil.getNode(document, xpath);
        }
        return getStateVariableType(cm, ownerClass, originalVariable);
    }

    private static JType getStateVariableType(JCodeModel cm, JDefinedClass ownerClass, Node stateVariable) throws XPathExpressionException {
        JType retVal = null;
        String dataType = XPathUtil.getStringValue(stateVariable, "dataType").trim();
        boolean isEnum = XPathUtil.getNode(stateVariable, "allowedValueList") != null;
        boolean optional = null != XPathUtil.getNode(stateVariable, "Optional");
        if (isEnum) {
            JPackage pkg = cm._package("org.saintandreas.serket.scpd");
            String name = XPathUtil.getStringValue(stateVariable, "name").trim();
            if (name.startsWith("A_ARG_TYPE_")) {
                name = name.substring("A_ARG_TYPE_".length());
            }
            try {
                JDefinedClass enumCls = ownerClass._enum(name);
                for (String s : XPathUtil.getStrings(stateVariable, "allowedValueList/allowedValue")) {
                    enumCls.enumConstant(s.trim());
                }
                retVal = enumCls;
            } catch (JClassAlreadyExistsException e) {
                retVal = cm.ref(pkg.name() + "." + ownerClass.name() + "." + name);
            }
        } else if ("string".equals(dataType)) {
            retVal = cm._ref(String.class);
        } else if ("boolean".equals(dataType)) {
            retVal = cm._ref(optional ? Boolean.class : boolean.class);
        } else if ("uri".equals(dataType)) {
            retVal = cm._ref(String.class);
        } else if (dataType.startsWith("ui") || dataType.startsWith("i")) {
            retVal = cm._ref(optional ? Integer.class : int.class);
        } 
        if (retVal == null) {
            throw new RuntimeException("unknown type");
        }
        return retVal;
    }

//    private static void createField(JDefinedClass cls, Element e) throws XPathExpressionException {
//        String name = XPathUtil.getStringValue(e, "name").trim();
//        boolean eventsAttr = "yes".equalsIgnoreCase(XPathUtil.getStringValue(e, "sendEventsAttribute").trim());
//    }
}