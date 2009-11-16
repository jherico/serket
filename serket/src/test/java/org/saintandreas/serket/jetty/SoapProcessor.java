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
package org.saintandreas.serket.jetty;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("serial")
public abstract class SoapProcessor extends HttpServlet {
    private static final Log LOG = LogFactory.getLog(SoapProcessor.class);

    protected static MessageFactory MESSAGE_FACTORY; static {
        try {
            MESSAGE_FACTORY = MessageFactory.newInstance();
        } catch (SOAPException e) { }
    }
    
    @SuppressWarnings("unchecked")
    public static MimeHeaders getMIMEHeaders(HttpServletRequest request) {
        MimeHeaders mimeHeaders = new MimeHeaders();
        for (String headerName : Collections.list((Enumeration<String>)request.getHeaderNames())) {
            String headerValue = request.getHeader(headerName);
            StringTokenizer st = new StringTokenizer(headerValue, ",");
            while (st.hasMoreTokens()) {
                mimeHeaders.addHeader(headerName, st.nextToken().trim());
            }
        }
        return mimeHeaders;
    }


    
    public static SOAPMessage getSoapMessage(HttpServletRequest request) throws IOException, SOAPException {
        return MESSAGE_FACTORY.createMessage(getMIMEHeaders(request), request.getInputStream());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getHeader("soapaction"); 
        if (null != action) {
            try {
                if (action.startsWith("\"") && action.endsWith("\"")) {
                    action = action.substring(1, action.length() - 1);
                }
                doSoap(action, getSoapMessage(request), response);
            } catch (SOAPException e) {
                throw new ServletException("unable to handle soap message", e);
            }
        }
    }

    protected abstract void doSoap(String action, SOAPMessage msg, HttpServletResponse response) throws SOAPException, ServletException;
}
