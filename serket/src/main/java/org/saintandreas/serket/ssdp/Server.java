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
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.test.SSDPTests;

import com.google.common.base.Charsets;

public class Server {
    protected ExecutorService executor;

    public Server() {
        this.executor = Executors.newCachedThreadPool();
    }

    public Server(ExecutorService executor) {
        this.executor = executor;
    }

    public void listen() {
        executor.submit(new Listener());
    }
    
    protected class Listener implements Runnable {
        @Override
        public void run() {
            MulticastSocket socket;
            try {
                socket = new MulticastSocket(SSDP.DEFAULT_PORT);
                socket.setReuseAddress(true);
                socket.joinGroup(SSDP.MULTICAST_ADDRESS);
                socket.setSoTimeout(1000);
                byte [] buffer = new byte[8192];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                while (!executor.isShutdown()) {
                    try {
                        socket.receive(packet);
                        executor.submit(new Handler(packet));
                        buffer = new byte[8192];
                        packet = new DatagramPacket(buffer, buffer.length);
                    } catch (SocketTimeoutException e) {
                        continue;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    protected class Handler implements Runnable {
        DatagramPacket packet;

        public Handler(DatagramPacket packet) {
            this.packet = packet;
        }

        @Override
        public void run() {
            String data = new String(packet.getData(), 0, packet.getLength(), Charsets.UTF_8);
            LogFactory.getLog(SSDPTests.class).debug(data);
        }

    }

}
