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
package org.saintandreas.serket.service.av;

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