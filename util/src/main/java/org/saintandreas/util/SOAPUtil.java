package org.saintandreas.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class SOAPUtil {
    public static MessageFactory MESSAGE_FACTORY;

    static {
        try {
            MESSAGE_FACTORY = MessageFactory.newInstance();
        } catch (SOAPException e) { }
    }

    protected static SOAPMessage createMessage() throws SOAPException {
        return MESSAGE_FACTORY.createMessage();
    }
    
    public static SOAPMessage parse(HttpServletRequest request) throws IOException, SOAPException {
        return parse(getMIMEHeaders(request), request.getInputStream());
    }

    public static SOAPMessage parse(MimeHeaders headers, InputStream stream) throws IOException, SOAPException {
        return MESSAGE_FACTORY.createMessage(headers, stream);
    }

    @SuppressWarnings("unchecked")
    public static MimeHeaders getMIMEHeaders(HttpServletRequest request) {
        MimeHeaders retVal = new MimeHeaders();
        for (String header : Collections.list((Enumeration<String>) request.getHeaderNames())) {
            for (String value : request.getHeader(header).split(",")) {
                retVal.addHeader(header, value.trim());
            }
        }
        return retVal;
    }

}
