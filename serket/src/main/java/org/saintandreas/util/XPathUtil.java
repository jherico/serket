package org.saintandreas.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XPathUtil {
    private static ThreadLocal<Map<String, XPathExpression>> sCache = new ThreadLocal<Map<String, XPathExpression>>();
    private static XPathFactory sFactory = XPathFactory.newInstance();

    private static Map<String, XPathExpression> getCache() {
        Map<String, XPathExpression> mRetVal = sCache.get();
        if (mRetVal == null) {
            mRetVal = new HashMap<String, XPathExpression>();
            sCache.set(mRetVal);
        }
        return mRetVal;
    }

    public static XPathExpression getXPath(String exp) throws XPathExpressionException {
        Map<String, XPathExpression> cache = getCache();
        if (!cache.containsKey(exp)) {
            cache.put(exp, sFactory.newXPath().compile(exp));
        }
        return cache.get(exp);
    }

    public static XPathExpression getXPath(String exp, NamespaceContext ctx) throws XPathExpressionException {
        if (ctx == null) {
            return getXPath(exp);
        }
        XPath mRetVal = sFactory.newXPath();
        mRetVal.setNamespaceContext(ctx);
        return mRetVal.compile(exp);
    }

    public static XPathExpression getXPathNoCache(String exp) throws XPathExpressionException {
        return sFactory.newXPath().compile(exp);
    }

    public static String[] getStrings(Object doc, XPathExpression path) throws XPathExpressionException {
        Node[] mNodes = getNodes(doc, path);

        String[] mRetVal = new String[mNodes.length];
        for (int i = 0; i < mNodes.length; ++i) {
            mRetVal[i] = mNodes[i].getTextContent().trim();
        }
        return mRetVal;
    }

    public static String[] getStrings(Object node, NamespaceContext ctx, String path) throws XPathExpressionException {
        return getStrings(node, getXPath(path, ctx));
    }

    public static String[] getStrings(Object node, String path) throws XPathExpressionException {
        return getStrings(node, null, path);
    }

    public static Element[] getElements(Object doc, XPathExpression path) throws XPathExpressionException {
        return XmlUtil.toElementArray((NodeList) path.evaluate(doc, XPathConstants.NODESET));
    }

    public static Element[] getElements(Object cms, NamespaceContext ctx, String path) throws XPathExpressionException {
        return getElements(cms, getXPath(path, ctx));
    }

    public static Element[] getElements(Object cms, String path) throws XPathExpressionException {
        return getElements(cms, null, path);
    }

    public static Node[] getNodes(Object doc, XPathExpression path) throws XPathExpressionException {
        return XmlUtil.toNodeArray((NodeList) path.evaluate(doc, XPathConstants.NODESET));
    }

    public static Node[] getNodes(Object cms, NamespaceContext ctx, String path) throws XPathExpressionException {
        return getNodes(cms, getXPath(path, ctx));
    }

    public static Node[] getNodes(Object cms, String path) throws XPathExpressionException {
        return getNodes(cms, null, path);
    }

    public static void setTextContent(Object node, XPathExpression path, String text) throws XPathExpressionException {
        for (Node n : getNodes(node, path)) {
            n.setTextContent(text);
        }
    }

    public static void setTextContent(Object node, NamespaceContext ctx, String path, String text) throws XPathExpressionException {
        setTextContent(node, getXPath(path, ctx), text);
    }

    public static void setTextContent(Object node, String path, String text) throws XPathExpressionException {
        setTextContent(node, null, path, text);
    }

    public static Set<String> getUniqueValues(Object doc, XPathExpression path) throws Exception {
        Set<String> mRetVal = new HashSet<String>();
        for (String s : getStrings(doc, path)) {
            mRetVal.add(s.trim());
        }
        return mRetVal;
    }

    public static Set<String> getUniqueValues(Object doc, NamespaceContext ctx, String path) throws Exception {
        return getUniqueValues(doc, getXPath(path, ctx));
    }

    public static Set<String> getUniqueValues(Object doc, String path) throws Exception {
        return getUniqueValues(doc, null, path);
    }

    public static String getStringValue(Object doc, XPathExpression path) throws XPathExpressionException {
        return path.evaluate(doc);
    }

    public static String getStringValue(Object doc, NamespaceContext ctx, String path) throws XPathExpressionException {
        return getStringValue(doc, getXPath(path, ctx));
    }

    public static String getStringValue(Object doc, String path) throws XPathExpressionException {
        return getStringValue(doc, null, path);
    }

    public static Node getNode(Object doc, XPathExpression path) throws XPathExpressionException {
        return (Node) path.evaluate(doc, XPathConstants.NODE);
    }

    public static Node getNode(Object doc, NamespaceContext ctx, String path) throws XPathExpressionException {
        return getNode(doc, getXPath(path, ctx));
    }

    public static Node getNode(Object doc, String path) throws XPathExpressionException {
        return getNode(doc, null, path);
    }

    public static void truncate(Object node, XPathExpression path, int len) throws XPathExpressionException, DOMException {
        for (Node n : XPathUtil.getNodes(node, path)) {
            String text = n.getTextContent();
            if ((text != null) && (text.length() > len)) {
                text = text.substring(0, len - 4) + "...";
            }
            n.setTextContent(text);
        }
    }

    public static void truncate(Object node, NamespaceContext ctx, String path, int len) throws XPathExpressionException, DOMException {
        truncate(node, getXPath(path, ctx), len);
    }

    public static void truncate(Object node, String path, int len) throws XPathExpressionException, DOMException {
        truncate(node, null, path, len);
    }

}
