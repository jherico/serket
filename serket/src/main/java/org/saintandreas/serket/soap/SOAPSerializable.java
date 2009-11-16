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
    
    public abstract void parse(SOAPMessage soapmessage);
    public abstract SOAPMessage format();
}
