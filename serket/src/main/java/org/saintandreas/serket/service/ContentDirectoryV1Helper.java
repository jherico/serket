package org.saintandreas.serket.service;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;


public class ContentDirectoryV1Helper {
    protected static MessageFactory MESSAGE_FACTORY; static {
        try {
            MESSAGE_FACTORY = MessageFactory.newInstance();
        } catch (SOAPException e) { }
    }

    public static SOAPMessage createBrowseResponse(String resultDidl, int count, int total, String updateId) throws SOAPException {
        SOAPMessage responseMsg = MESSAGE_FACTORY.createMessage();
        SOAPBody body = responseMsg.getSOAPBody();
        SOAPBodyElement element = body.addBodyElement(new QName(ContentDirectoryV1.URI, "BrowseResponse", "u"));
        element.addChildElement("Result").setTextContent(resultDidl);
        element.addChildElement("NumberReturned").setTextContent("3");
        element.addChildElement("TotalMatches").setTextContent("3");
        element.addChildElement("UpdateID").setTextContent("0");
        return responseMsg;
    }
    
}
