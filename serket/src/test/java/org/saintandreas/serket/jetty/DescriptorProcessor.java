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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.http.HttpHeaders;
import org.saintandreas.util.StringUtil;

@SuppressWarnings("serial")
public class DescriptorProcessor extends HttpServlet{
    private static Log LOG = LogFactory.getLog(DescriptorProcessor.class);

    private static String DESCRIPTOR_FORMAT = null; static {
        try { 
            DESCRIPTOR_FORMAT = StringUtil.readFromResource("/descriptor.xml");
        } catch (IOException e) {} 
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.info("responding to descriptor request");
        response.setHeader(HttpHeaders.CONTENT_TYPE, "text/xml; charset=\"utf-8\"");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        response.setHeader(HttpHeaders.EXPIRES,  "0");
        response.setHeader(HttpHeaders.ACCEPT_RANGES, "bytes");
        response.setHeader(HttpHeaders.CONNECTION, "keep-alive");
        
//        String s = DESCRIPTOR_FORMAT.replaceAll("%udn%", NewConfig.getUID());
//        s = s.replaceAll("%port%", Short.toString(NewConfig.getServerPort()));
//        s = s.replace("%host%", NewConfig.getServerHostname());
//        s = s.replace("%friendlyname%", NewConfig.getServerFriendlyName());
//        response.getWriter().write(s);
    }
}
