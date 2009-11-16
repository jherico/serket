package org.saintandreas.serket.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.saintandreas.serket.soap.SOAPSerializable;
import org.saintandreas.util.XPathUtil;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.sun.codemodel.ClassType;
import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JFieldRef;
import com.sun.codemodel.JForEach;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;
import com.sun.codemodel.writer.SingleStreamCodeWriter;

public class CodeModelTest {

    //    <scpd>
    //      <serviceStateTable>
    //        <stateVariable>

    public static void main(String[] args) throws JClassAlreadyExistsException, IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        JCodeModel cm = new JCodeModel();

        String serviceName = "ContentDirectory3";
        Document scpdDoc = XmlUtil.parseXmlResource("/scpd/" + serviceName + ".xml");
        JDefinedClass cls = cm._class("org.saintandreas.serket.scpd." + serviceName, ClassType.INTERFACE);
        for (Element e : XPathUtil.getElements(scpdDoc, "/scpd/actionList/action")) {
            createAction(cm, cls, e);
        }
//        for (Element e : XPathUtil.getElements(scpdDoc, "/scpd/serviceStateTable/stateVariable")) {
//            createField(cls, e);
//        }


        //        JMethod m = cls.method(JMod.PUBLIC, cm.VOID, "foo");
        //        m.body().decl(cm.INT, "getCount");
        //
        //        // This is not exactly right because we need to
        //        // support generics
        //        JClass arrayListclass = cm.ref(ArrayList.class);
        //        JVar $list = m.body().decl(arrayListclass, "alist",
        //                JExpr._new(arrayListclass));
        //
        //        JClass $integerclass = cm.ref(Integer.class);
        //        JForEach foreach = m.body().forEach($integerclass, "count", $list);
        //        JVar $count1 = foreach.var();
        //        foreach.body().assign(JExpr.ref("getCount"), JExpr.lit(10));
        //
        //        // printing out the variable
        //        JFieldRef out1 = cm.ref(System.class).staticRef("out");
        //        // JInvocation invocation =
        //        foreach.body().invoke(out1, "println").arg($count1);

        cm.build(new SingleStreamCodeWriter(System.out));

    }


    private static void createAction(JCodeModel cm, JDefinedClass cls, Element e) throws XPathExpressionException, JClassAlreadyExistsException {
        String name = XPathUtil.getStringValue(e, "name");
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
        JType retVal = null;
        if (args.length == 0) {
            retVal = cm.VOID;
        } /* else if (args.length == 1) {
            Element outArg = args[0];
            String relatedStateVariable = XPathUtil.getStringValue(outArg, "relatedStateVariable");
            retVal = getStateVariableType(cm, relatedStateVariable, outArg.getOwnerDocument());
        } */ else {
            JDefinedClass returnClass = cls._class(name + (out ? "Response" : "Request"));
            returnClass._implements(SOAPSerializable.class);
            for (Element outArg : args) {
                String relatedStateVariable = XPathUtil.getStringValue(outArg, "relatedStateVariable");
                String fieldName =  XPathUtil.getStringValue(outArg, "name");
                JType fieldType = getStateVariableType(cm, relatedStateVariable, outArg.getOwnerDocument());
                returnClass.field(JMod.PUBLIC, fieldType, fieldName);
            }
            retVal = returnClass;
        }
        return retVal;
    }

    private static JType getStateVariableType(JCodeModel cm, String stateVariable, Document document) throws XPathExpressionException {
        Node originalVariable = XPathUtil.getNode(document, "/scpd/serviceStateTable/stateVariable[name='"+ stateVariable + "']");
        return getStateVariableType(cm, originalVariable);
    }
    
    private static JType getStateVariableType(JCodeModel cm, Node stateVariable) throws XPathExpressionException {
        JType retVal = null;
        String dataType = XPathUtil.getStringValue(stateVariable, "dataType");
        boolean isEnum = XPathUtil.getNode(stateVariable, "allowedValueList") != null;
        boolean optional = null != XPathUtil.getStringValue(stateVariable, "Optional");
        if (isEnum) {
            String[] values = XPathUtil.getStrings(stateVariable, "allowedValueList/allowedValue");
            retVal = cm._ref(Object.class);
        } else {
            if ("string".equals(dataType)) {
                retVal = cm._ref(String.class);        
            } else if ("boolean".equals(dataType)) {
                retVal = cm._ref(optional ? Boolean.class : boolean.class);
            } else if ("uri".equals(dataType)) {
                retVal = cm._ref(String.class);
            } else if (dataType.startsWith("ui") || dataType.startsWith("i")) {
                retVal = cm._ref(optional ? Integer.class : int.class);
            } else {
                throw new RuntimeException("unknown type");
            }
        }
        return retVal;
    }

    private static void createField(JDefinedClass cls, Element e) throws XPathExpressionException {
        String name = XPathUtil.getStringValue(e, "name");
        boolean eventsAttr = "yes".equalsIgnoreCase(XPathUtil.getStringValue(e, "sendEventsAttribute"));

        //<scpd>
        //  <serviceStateTable>
        //    <stateVariable>
        //    <Optional/>
        //    <name>A_ARG_TYPE_TransferStatus</name>
        //    <sendEventsAttribute>no</sendEventsAttribute>
        //    <dataType>string</dataType>
        //    <allowedValueList>
        //        <allowedValue>COMPLETED</allowedValue>
        //        <allowedValue>ERROR</allowedValue>
        //        <allowedValue>IN_PROGRESS</allowedValue>
        //        <allowedValue>STOPPED</allowedValue>
        //    </allowedValueList>
        //</stateVariable>
        // </serviceStateTable>
        // </scpd>

    }
}
