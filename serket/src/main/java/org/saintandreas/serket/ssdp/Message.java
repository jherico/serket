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


public class Message {

    private final static String NOTIFY_START = "NOTIFY * HTTP/1.1\r\n";
    private final static String NOTIFY_TYPE_TEMPLATE = "NTS: %s\r\n";
    private final static String SEARCH_START = "M-SEARCH * HTTP/1.1\r\n";
    private final static String SEARCH_DISCOVER = "MAN: \"ssdp:discover\"\r\n"; 
    private final static String HTTP_OK_START = "HTTP/1.1 200 OK\r\n";
    private final static String SYSTEM_IDENTIFIER = System.getProperty("os.name") + "/" + System.getProperty("os.version");
    private final static String NOTIFICATION_TYPE_TEMPLATE = "NT: %s\r\n";
    private final static String UNIQUE_SERVICE_NAME_TEMPLATE = "USN: %s\r\n"; 
    private final static String SERVER_TEMPLATE = "SERVER: " + SYSTEM_IDENTIFIER + " UPnP/1.1 %s\r\n"; 
    private final static String USER_AGENT_TEMPLATE = "USER-AGENT: " + SYSTEM_IDENTIFIER + " UPnP/1.1 %s\r\n"; 
    private final static String MULTICAST_HOST = "HOST: 239.255.255.250:1900\r\n";

    private final static String NOTIFY_TEMPLATE =
        NOTIFY_START + 
        MULTICAST_HOST + 
        NOTIFY_TYPE_TEMPLATE +
        NOTIFICATION_TYPE_TEMPLATE +
        UNIQUE_SERVICE_NAME_TEMPLATE;
        
    private final static String NOTIFY_ALIVE_TEMPLATE = 
        "LOCATION: %s\r\n" +
        "CACHE-CONTROL: max-age=%d\r\n" +
        SERVER_TEMPLATE + "\r\n";

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

    private final static String NOTIFY_ALIVE = "ssdp:update";
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
    
    public final static String SEARCH_TEAMPLTE = 
        SEARCH_START +
        MULTICAST_HOST +
        SEARCH_DISCOVER + 
        USER_AGENT_TEMPLATE +
        "ST: %s\r\n" + 
        "MX: %d\r\n" +
        "\r\n";


}
