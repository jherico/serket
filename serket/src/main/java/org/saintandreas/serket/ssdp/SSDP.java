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

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.google.common.base.Charsets;

public class SSDP {
    public final static InetAddress MULTICAST_ADDRESS;
    public final static short DEFAULT_PORT = 1900;

    static {
        try {
            MULTICAST_ADDRESS = InetAddress.getByName("239.255.255.250");
        } catch (UnknownHostException e) {
            // Should be unreachable code
            throw new RuntimeException(e);
        }
    }

    
    public static DatagramPacket getPacket(String data) {
        byte[] buffer = data.getBytes(Charsets.UTF_8);
        return new DatagramPacket(buffer, buffer.length, MULTICAST_ADDRESS, DEFAULT_PORT);
    }

}
