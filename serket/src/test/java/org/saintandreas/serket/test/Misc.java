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

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.TreeSet;

import org.junit.Test;
import org.saintandreas.serket.service.ServiceType;

public class Misc {
    @Test
    public void testServiceTypeEnums() throws UnknownHostException {
        TreeSet<String> set = new TreeSet<String>();
        for (Object o : System.getProperties().keySet()) {
            set.add(o.toString());
        }
        for (String s : set) {
            System.out.println(s);
        }
        for (ServiceType type : ServiceType.values()) {
            System.out.println(type.name());
            System.out.println(type.scpdResourcePath());
        }
        System.out.println(InetAddress.getLocalHost().getHostName());
    }
}
