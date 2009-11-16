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
package org.saintandreas.serket;

public final class Serket {
    private Serket() {

    }

    public static String VERSION = "0.1";
    public static String SERVER_TOKEN = "SerketLib/" + VERSION;
    public static String UPNP_URN_PREFIX = "urn:schemas-upnp-org:";
    public static String UPNP_DEVICE_URN_PREFIX = UPNP_URN_PREFIX + "device:";
    public static String UPNP_SERVICE_URN_PREFIX = UPNP_URN_PREFIX + "service:";
    public static String PROJECT_URL = "http://code.google.com/p/serket/";
}
