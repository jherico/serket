/*
 * Copyright (C) 2009 Bradley Austin Davis.
 * 
 * This file is part of serket.
 * 
 * serket is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * serket is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * serket. If not, see <http://www.gnu.org/licenses/>.
*/
package org.saintandreas.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.google.common.base.Charsets;

/**
 * @author bdavis@saintandreas.org
 *
 */
public final class XmlUtil {
    private XmlUtil() {
    }
    
    public final static String XML_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    public final static String XML_DATE_FORMAT = "yyyy-MM-dd";
    public final static String XML_TIME_FORMAT = "HH:mm:ssZ";

    private final static DocumentBuilderFactory sDocumentBuilderFactory;
    private final static DocumentBuilder sDocumentBuilder;
    private final static TransformerFactory sTransformerFactory; 
    static {
        sDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
        sDocumentBuilderFactory.setNamespaceAware(true);
        sDocumentBuilderFactory.setIgnoringElementContentWhitespace(true);
        sTransformerFactory = TransformerFactory.newInstance();
        try {
            sDocumentBuilder = sDocumentBuilderFactory.newDocumentBuilder();
            sDocumentBuilder.setErrorHandler(new ErrorHandler() {
                public void warning(SAXParseException exception) throws SAXException {}
                public void error(SAXParseException exception) throws SAXException {}
                public void fatalError(SAXParseException exception) throws SAXException {}
            });
        } catch (ParserConfigurationException e) {
            // should never happen
            throw new RuntimeException(e);
        }
    }
    
    private synchronized static Transformer getTransformer() throws TransformerConfigurationException {
        return sTransformerFactory.newTransformer();
    }

    public static Document parseXmlResource(String resource) throws SAXException, IOException, ParserConfigurationException {
        return parseXmlResource(resource, Charsets.UTF_8);
    }

    public static Document parseXmlResource(String resource, Charset charset) throws SAXException, IOException, ParserConfigurationException {
        return parseXmlStream(StreamUtil.getResourceAsStream(resource), charset);
    }

    public static Document parseXmlString(String xml) throws SAXException, IOException, ParserConfigurationException {
        return parseXmlReader(new StringReader(xml));
    }

    public static Document parseXmlStream(InputStream stream) throws SAXException, IOException, ParserConfigurationException {
        return parseXmlStream(stream, Charsets.UTF_8);
    }

    public static Document parseXmlStream(InputStream stream, Charset charset) throws SAXException, IOException, ParserConfigurationException {
        return parseXmlReader(new InputStreamReader(stream, charset));
    }

    // TODO fix this
    public static synchronized Document parseXmlReader(Reader reader) throws SAXException, IOException, ParserConfigurationException {
        return sDocumentBuilder.parse(new InputSource(reader));
    }

    public static Document parseXmlFile(String path) throws SAXException, IOException, ParserConfigurationException  {
        return parseXmlFile(new File(path), Charsets.UTF_8);
    }

    public static Document parseXmlFile(String path, Charset charset) throws SAXException, IOException, ParserConfigurationException  {
        return parseXmlFile(new File(path), charset);
    }

    public static Document parseXmlFile(File path) throws SAXException, IOException, ParserConfigurationException  {
        return parseXmlFile(path, Charsets.UTF_8);
    }

    public static Document parseXmlFile(File path, Charset charset) throws SAXException, IOException, ParserConfigurationException  {
        InputStream mStream = null;
        try {
            return parseXmlStream(mStream = new FileInputStream(path), charset);
        } finally {
            StreamUtil.safeClose(mStream);
        }
    }

    public static synchronized Document createDocument() {
        return sDocumentBuilder.newDocument();
    }

    public static Document createDocument(String[] path)  {
        Document mRetVal = createDocument();

        Node mCur = mRetVal;
        for (String s : path) {
            Element mNewElement = mRetVal.createElement(s);
            mCur.appendChild(mNewElement);
            mCur = mNewElement;
        }
        return mRetVal;
    }

    public static Document createDocument(String initialPath) {
        if ((initialPath != null) && !"".equals(initialPath)) {
            return createDocument(initialPath.split("/"));
        } else {
            return createDocument();
        }
    }

    public static void writeXml(Node node, Writer writer) throws IOException {
        try {
            getTransformer().transform(new DOMSource(node), new StreamResult(writer));
        } catch (TransformerException e) {
            throw new IOException(e);
        } finally {
            writer.close();
        }
    }

    public static String formatXmlElement(Element elem) throws IOException  {
        return formatXmlNode(elem);
    }

    public static String formatXmlDocument(Document doc) throws IOException  {
        return formatXmlNode(doc);
    }

    public static String formatXmlNode(Node node) throws IOException  {
        StringWriter mWriter = new StringWriter();
        writeXml(node, mWriter);
        return mWriter.toString();
    }

    public static void writeXmlFile(Document doc, File file) throws IOException {
        writeXmlFile(doc, file, Charsets.UTF_8);
    }

    public static void writeXmlFile(Document doc, File file, Charset charset) throws IOException {
        writeXmlStream(doc, new FileOutputStream(file), charset);
    }

    public static void writeXmlStream(Document doc, OutputStream stream) throws IOException {
        writeXmlStream(doc, stream, Charsets.UTF_8);
    }

    public static void writeXmlStream(Document doc, OutputStream stream, Charset charset) throws IOException {
        try {
            writeXml(doc, new OutputStreamWriter(stream, charset));
        } finally {
            StreamUtil.safeClose(stream);
        }
    }


    public static Element createElement(Node element, String name) {
        return element.getOwnerDocument().createElement(name);
    }

    public static Element addAttributes(Element element, String[][] attributes) {
        for (String[] attr : attributes) {
            element.setAttribute(attr[0], attr[1]);
        }
        return element;
    }

    public static Element addChildElement(Node element, String name) {
        return addChildElement(element, name, null, (String[][]) null);
    }

    public static Element addChildElement(Node element, String name, String value) {
        return addChildElement(element, name, value, (String[][]) null);
    }

    public static void addChildElementIfNotNull(Node element, String name, String value) {
        if (value != null) {
            addChildElement(element, name, value, (String[][]) null);
        }
    }

    public static Element addChildElement(Node element, String name, String[][] attributes) {
        return addChildElement(element, name, null, attributes);
    }

    public static Element addChildCdataElement(Node parent, String name, String cdata) {
        Element mElement = addChildElement(parent, name);
        mElement.appendChild(mElement.getOwnerDocument().createCDATASection(cdata));
        return mElement;
    }

    public static Element addChildElement(Node element, String name, String value, String[][] attributes) {
        Element child = createElement(element, name);
        if (value != null) {
            child.setTextContent(value);
        }
        if (attributes != null) {
            addAttributes(child, attributes);
        }
        element.appendChild(child);
        return child;
    }

    public static Element addElementPath(Node element, String path) {
        return addElementPath(element, path.split("/"));
    }

    public static Element addElementPath(Node element, String[] path) {
        Element mRetVal = null;
        for (String s : path) {
            mRetVal = addChildElement(mRetVal == null ? element : mRetVal, s);
        }
        return mRetVal;
    }


    protected static String fixTimezone(String string) {
        int insert = string.length() - 2;
        return string.substring(0, insert) + ":" + string.substring(insert);
    }

    public static Date parseXmlDateTime(String dateTime) throws ParseException {
        return (new SimpleDateFormat(XML_DATETIME_FORMAT)).parse(dateTime);
    }

    // 2002-09-24
    public static String getXmlDate(Date date) {
        return (new SimpleDateFormat(XML_DATE_FORMAT)).format(date);
    }

    // 2002-09-24T09:00:00-07:00
    public static String getXmlDateTime(Date date) {
        return fixTimezone((new SimpleDateFormat(XML_DATETIME_FORMAT)).format(date));
    }

    // 09:00:00-07:00
    public static String getXmlTime(Date date) {
        return fixTimezone((new SimpleDateFormat(XML_TIME_FORMAT)).format(date));
    }

    public static Node[] toNodeArray(NodeList list) {
        int length = list.getLength();
        Node[] mRetVal = new Node[length];
        for (int i = 0; i < length; ++i) {
            mRetVal[i] = list.item(i);
        }
        return mRetVal;
    }

    public static Element[] toElementArray(NodeList list) {
        Node[] nodes = toNodeArray(list);
        List<Element> retVal = new ArrayList<Element>();
        for (Node n : nodes) {
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                retVal.add((Element)n);
            }
        }
        return retVal.toArray(new Element[]{});
    }

    public static String prettyPrint(Node doc) throws TransformerException  {
        StringWriter mWriter = new StringWriter();
        prettyPrint(doc, mWriter);
        return mWriter.toString();
    }

    public static void prettyPrint(Node doc, Writer out) throws TransformerException  {
        Transformer serializer = sTransformerFactory.newTransformer();
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        serializer.transform(new DOMSource(doc), new StreamResult(out));
    }



    @SuppressWarnings("unchecked")
    public static <T extends Node> List<T> getNodesOfType(NodeList list, short type) {
        List<T> retVal = new ArrayList<T>(list.getLength());
        for (int i = 0; i < list.getLength(); ++i) {
            Node n = list.item(i);
            if (n.getNodeType() == type) {
                retVal.add((T) n);
            }
        }
        return retVal;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Node> List<T> getNodesOfType(NamedNodeMap list, short type) {
        List<T> retVal = new ArrayList<T>(list.getLength());
        for (int i = 0; i < list.getLength(); ++i) {
            Node n = list.item(i);
            if (n.getNodeType() == type) {
                retVal.add((T) n);
            }
        }
        return retVal;
    }

    public static <T extends Node> List<T> getNodesOfType(Node parent, short type) {
        return getNodesOfType(parent.getChildNodes(), type);
    }
    
    public static List<Attr> getAttributes(Node node) {
        return getNodesOfType(node.getChildNodes(), Node.ATTRIBUTE_NODE);
    }

    public static List<Element> getChildElements(Node node) {
        return getNodesOfType(node.getChildNodes(), Node.ELEMENT_NODE);
    }

    public static List<Element> getChildElements(Node node, String name) {
        List<Element> original = getNodesOfType(node.getChildNodes(), Node.ELEMENT_NODE);
        List<Element> retVal = new ArrayList<Element>(original.size());
        for (Element e : original) {
            if (e.getNodeName().equals(name)) {
                retVal.add(e);
            }
        }
        return retVal;
    }
}
