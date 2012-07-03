package org.saintandreas.util;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public abstract class SOAPSerializable {
    
    public abstract void parse(SOAPMessage soapmessage) throws SOAPException;
    public abstract SOAPMessage format() throws SOAPException;

    protected static SOAPMessage createMessage() throws SOAPException {
        return SOAPUtil.createMessage();
    }
   
}
