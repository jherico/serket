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
package org.saintandreas.serket.ssdp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.impl.io.AbstractMessageParser;
import org.apache.http.impl.io.AbstractSessionInputBuffer;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import com.google.common.base.Charsets;


public class Message {

    public final static String NOTIFY_START = "NOTIFY * HTTP/1.1\r\n";
    public final static String SEARCH_START = "M-SEARCH * HTTP/1.1\r\n";
    public final static String HTTP_OK_START = "HTTP/1.1 200 OK\r\n";

    private final static String NOTIFY_TYPE_TEMPLATE = "NTS: %s\r\n";
    private final static String CACHE_CONTROL_TEMPLATE = "CACHE-CONTROL: max-age=%d\r\n";
    private final static String SEARCH_DISCOVER = "MAN: \"ssdp:discover\"\r\n"; 
    private final static String SYSTEM_IDENTIFIER = System.getProperty("os.name") + "/" + System.getProperty("os.version");
    private final static String NOTIFICATION_TYPE_TEMPLATE = "NT: %s\r\n";
    private final static String UNIQUE_SERVICE_NAME_TEMPLATE = "USN: %s\r\n"; 
    private final static String SERVER_TEMPLATE = "SERVER: " + SYSTEM_IDENTIFIER + " UPnP/1.1 %s\r\n";
    private final static String LOCATION_TEMPLATE = "LOCATION: %s\r\n";
    private final static String USER_AGENT_TEMPLATE = "USER-AGENT: " + SYSTEM_IDENTIFIER + " UPnP/1.1 %s\r\n"; 
    private final static String MULTICAST_HOST = "HOST: 239.255.255.250:1900\r\n";
    private final static String SEARCH_TARGET_TEMPLATE = "ST: %s\r\n";

    public static enum Type {
        NOTIFY_ALIVE, NOTIFY_BYEBYE, NOTIFY_UPDATE, SEARCH, RESPONSE
    }
    
    private final static String NOTIFY_TEMPLATE =
        NOTIFY_START + 
        MULTICAST_HOST + 
        NOTIFY_TYPE_TEMPLATE +
        NOTIFICATION_TYPE_TEMPLATE +
        UNIQUE_SERVICE_NAME_TEMPLATE;
        
    private final static String NOTIFY_ALIVE_TEMPLATE = 
        LOCATION_TEMPLATE +
        CACHE_CONTROL_TEMPLATE +
        SERVER_TEMPLATE + 
        "\r\n";

//    private final static String NOTIFY_UPDATE_TEMPLATE = 
//        NOTIFY_START + 
//        MULTICAST_HOST + 
//        NOTIFY_UPDATE +
//        NOTIFICATION_TYPE_TEMPLATE +
//        UNIQUE_SERVICE_NAME_TEMPLATE;
//
//    private final static String NOTIFY_BYEBYE_TEMPLATE = 
//        NOTIFY_START + 
//        MULTICAST_HOST + 
//        NOTIFY_BYEBYE +
//        NOTIFICATION_TYPE_TEMPLATE +
//        UNIQUE_SERVICE_NAME_TEMPLATE;

    private final static String NOTIFY_ALIVE = "ssdp:alive";
    private final static String NOTIFY_UPDATE = "ssdp:update";
    private final static String NOTIFY_BYEBYE = "ssdp:byebyte";

    private static String buildNotifyMessage(String notificationMessageType, String notificationType, String uniqueServiceName) {
        return String.format(NOTIFY_TEMPLATE, notificationMessageType, notificationType, uniqueServiceName);
    }

    public static String buildNotifyAliveMessage(String notificationType, String uniqueServiceName, String location, long expireSeconds, String serverSuffix) {
        return buildNotifyMessage(NOTIFY_ALIVE, notificationType, uniqueServiceName) + String.format(NOTIFY_ALIVE_TEMPLATE, location, expireSeconds, serverSuffix) + "\r\n";
    }

    public static String buildNotifyUpdateMessage(String notificationType, String uniqueServiceName, String location, long expireSeconds, String serverSuffix) {
        return buildNotifyMessage(NOTIFY_UPDATE, notificationType, uniqueServiceName) + "\r\n";
    }

    public static String buildNotifyByeByeMessage(String notificationType, String uniqueServiceName, String location, long expireSeconds, String serverSuffix) {
        return buildNotifyMessage(NOTIFY_BYEBYE, notificationType, uniqueServiceName) + "\r\n";
    }

    private final static String SEARCH_TEAMPLTE = 
        SEARCH_START +
        MULTICAST_HOST +
        SEARCH_DISCOVER + 
        USER_AGENT_TEMPLATE +
        SEARCH_TARGET_TEMPLATE + 
        "MX: %d\r\n" +
        "\r\n";


    public static String buildSearchMessage(String searchType, int seconds) {
        return String.format(SEARCH_TEAMPLTE, "serket/1.0", searchType, seconds);
    }

    private final static String SEARCH_RESPONSE_TEAMPLTE = 
        HTTP_OK_START +
        UNIQUE_SERVICE_NAME_TEMPLATE + 
        SEARCH_TARGET_TEMPLATE + 
        LOCATION_TEMPLATE +
        CACHE_CONTROL_TEMPLATE +
        SERVER_TEMPLATE + 
        "EXT:\r\n" +
        "\r\n";
    
    public static String buildSearchResponseMessage(String uniqueServiceName, String searchTarget, String location, long expireSeconds, String serverSuffix) {
        return String.format(SEARCH_RESPONSE_TEAMPLTE, uniqueServiceName, searchTarget, location,  expireSeconds, serverSuffix);
    }

    public final Type type;
    public final Map<String, Header> headers;
    public final String usn;
    public final DatagramPacket original;
    public final String originalString;
    
    public Message(Type type, Map<String, Header> headers, String usn, DatagramPacket original, String originalString) {
        this.type = type;
        this.headers = Collections.unmodifiableMap(headers);
        this.usn = usn;
        this.original = original;
        this.originalString = originalString;
    }
    
    public static class ByteArrayInputBuffer extends AbstractSessionInputBuffer {
        private final ByteArrayInputStream is;

        public ByteArrayInputBuffer(byte[] buffer) {
            this(buffer, new BasicHttpParams());
        }

        public ByteArrayInputBuffer(byte[] buffer, HttpParams params) {
            this(buffer, 8192, params);
        }

        public ByteArrayInputBuffer(byte[] buffer, int bufferSize, HttpParams params) {
            is = new ByteArrayInputStream(buffer);
            this.init(is, bufferSize, params);
        }
         
        @Override
        public boolean isDataAvailable(int timeout) throws IOException {
            boolean result = hasBufferedData();
            if (!result) {
                fillBuffer();
                result = hasBufferedData();
            }
            return result;
        }
        
    }
    
    public static Message parseMessage(DatagramPacket packet) throws IOException, HttpException {
        Type type;
        Map<String, Header> headers = new HashMap<String, Header>();
        String usn = null;
        
        LineParser parser = new BasicLineParser();
        SessionInputBuffer inBuffer = new ByteArrayInputBuffer(packet.getData());
        String command = inBuffer.readLine();
        Header[] hs = AbstractMessageParser.parseHeaders(inBuffer, 64, 1024, parser);
        for (Header h : hs) {
            headers.put(h.getName(), h);
        }
        
        if (Message.NOTIFY_START.startsWith(command)) {
            Header h = headers.get("NTS");
            usn = headers.get("USN").getValue();
            if ("ssdp:alive".equals(h.getValue())) {
                // LogFactory.getLog(SSDPTests.class).debug("Notify message alive " + usn);
                type = Type.NOTIFY_ALIVE;
            } else if ("ssdp:update".equals(h.getValue())) {
                // LogFactory.getLog(SSDPTests.class).debug("Notify message update " + usn);
                type = Type.NOTIFY_UPDATE;
            } else if ("ssdp:byebye".equals(h.getValue())) {
                // LogFactory.getLog(SSDPTests.class).debug("Notify message byebye " + usn);
                type = Type.NOTIFY_BYEBYE;
            } else throw new RuntimeException("unknown type");
        } else if (Message.SEARCH_START.startsWith(command)) {
            usn = headers.get("ST").getValue();
            // LogFactory.getLog(SSDPTests.class).debug("Search message " + usn);
            type = Type.SEARCH;
        } else if (Message.HTTP_OK_START.startsWith(command)) {
            // LogFactory.getLog(SSDPTests.class).debug("Response message");
            type = Type.RESPONSE;
        } else throw new RuntimeException("unknown type");
        return new Message(type, headers, usn, packet, new String(packet.getData(), 0, packet.getLength(), Charsets.US_ASCII));
    }
}
