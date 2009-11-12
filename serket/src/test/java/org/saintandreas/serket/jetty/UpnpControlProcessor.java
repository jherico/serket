package org.saintandreas.serket.jetty;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.http.HttpHeaders;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@SuppressWarnings("serial")
public class UpnpControlProcessor extends SoapProcessor {
    private static final Log LOG = LogFactory.getLog(UpnpControlProcessor.class);

    // "urn:schemas-upnp-org:service:ContentDirectory:1#Browse"
    public final static String CONTENT_DIR_1_PREFIX = "urn:schemas-upnp-org:service:ContentDirectory:1#";

    private static Map<String, String> getInArguments(Document doc) {
        Map<String, String> retVal = new HashMap<String, String>();
        for (Node n : XmlUtil.getNodesOfType(doc, Node.ELEMENT_NODE) ) {
            retVal.put(n.getNodeName(), n.getTextContent());
        }
        return retVal;
    }

    public void doSoap(String action, SOAPMessage msg, HttpServletResponse response) throws SOAPException, ServletException {
        if (action.startsWith(CONTENT_DIR_1_PREFIX)) {
            Map<String, String> args = getInArguments(msg.getSOAPBody().extractContentAsDocument());
            String command = action.substring(CONTENT_DIR_1_PREFIX.length());
            if (command.equals("Browse")) {
                doBrowse(args, response);
            }
        }
    }
    
    private static final String CRLF = "\r\n";

    protected void doBrowse(Map<String, String> args, HttpServletResponse httpresponse) throws ServletException, SOAPException {
        try {
            httpresponse.setHeader(HttpHeaders.CONTENT_TYPE, "text/xml; charset=\"utf-8\"");
//            String response = StringUtil.readFromResource("/browseResponse.xml");
//            httpresponse.getWriter().write(response);
//            SOAPMessage responseMsg = MESSAGE_FACTORY.createMessage();
//            SOAPBody body = responseMsg.getSOAPBody();
//            SOAPBodyElement element = body.addBodyElement(new QName("urn:schemas-upnp-org:service:ContentDirectory:1", "BrowseResponse", "u"));
//            element.addChildElement("Result").setTextContent(StringUtil.readFromResource("/didl2.xml"));
//            element.addChildElement("NumberReturned").setTextContent("3");
//            element.addChildElement("TotalMatches").setTextContent("3");
//            element.addChildElement("UpdateID").setTextContent("0");
//            responseMsg.writeTo(httpresponse.getOutputStream());
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
