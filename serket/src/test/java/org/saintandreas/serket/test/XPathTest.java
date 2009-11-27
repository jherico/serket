package org.saintandreas.serket.test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.saintandreas.util.XPathUtil;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XPathTest {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        Document doc = XmlUtil.parseXmlResource("/temp.xml");
        for (Node n : XPathUtil.getNodes(doc, "//span[contains(@class, 'body')]")) {
            System.out.println(XPathUtil.getStringValue(doc, "//span[@class='shared-content']/a/@data"));
        }
    }
}
