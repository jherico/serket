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
package org.saintandreas.serket.test;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;

public class SSDPTests {

    private static NetworkInterface wired = null;
    private static NetworkInterface wireless = null;
    private static InetAddress wiredIpv4 = null;
    private static InetAddress wiredIpv6 = null;
    static {
        try {
            for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                String name = ni.getDisplayName();
                if (name.contains("3945ABG")) {
                    wireless = ni;
                }
                if (name.contains("57xx")) {
                    wired = ni;
                    for (InetAddress ia : Collections.list(ni.getInetAddresses())) {
                        if (ia instanceof Inet4Address) {
                            wiredIpv4 = ia;
                        }
                        if (ia instanceof Inet6Address) {
                            wiredIpv6 = ia;
                        }
                        if (wiredIpv4 != null && wiredIpv6 != null) {
                            break;
                        }
                    }
                }
                if (wireless != null && wired != null) {
                    break;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void testAliveMessage() throws IOException {
//        UUID uuid = UUID.randomUUID();
//        String uuidStr = uuid.toString();
//        String usn = "uuid:" + uuidStr + "::" + ContentDirectoryV1.URI;
//        String result = Message.buildNotifyAliveMessage(ContentDirectoryV1.URI, usn, "http://localhost:1900/fail", 1800, Serket.SERVER_TOKEN);
//        DatagramPacket packet = SSDP.getPacket(result);
//        MulticastSocket socket = new MulticastSocket();
//        socket.setNetworkInterface(wireless);
//        socket.send(packet);
//    }
//
//    public static void main(String[] args) throws InterruptedException, IOException {
//        byte buffer[] = new byte[8192];
//        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//
//        MulticastSocket socket = new MulticastSocket(SSDP.DEFAULT_PORT);
////        socket.setNetworkInterface(wired);
//        socket.setReuseAddress(true);
//        socket.joinGroup(SSDP.MULTICAST_ADDRESS);
//        while (true) {
//            socket.receive(packet);
//            String data = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
//            if (data.contains(Serket.SERVER_TOKEN)) {
//                LogFactory.getLog(SSDPTests.class).debug(data);
//            }
//        }
//    }
}
