package org.saintandreas.serket.soap;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public abstract class SOAPSerializable {
    protected static MessageFactory MESSAGE_FACTORY; static {
        try {
            MESSAGE_FACTORY = MessageFactory.newInstance();
        } catch (SOAPException e) { }
    }
    
    protected static SOAPMessage createMessage() throws SOAPException {
        return MESSAGE_FACTORY.createMessage();
    }
    
    public abstract void parse(SOAPMessage soapmessage) throws SOAPException;
    public abstract SOAPMessage format() throws SOAPException;
}
