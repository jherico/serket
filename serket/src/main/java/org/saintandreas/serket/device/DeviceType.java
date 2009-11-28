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
package org.saintandreas.serket.device;

import org.saintandreas.serket.Serket;

public enum DeviceType {
    Basic, Printer, Scanner, DigitalSecurityCamera, 
    HVAC_System, HVAC_ZoneThermostat, DimmableLight, 
    InternetGatewayDevice, WANDevice, WANConnectionDevice, LANDevice, WLANAccessPoint, 
    MediaRenderer, MediaServer, MediaRenderer2(MediaRenderer, 2), MediaServer2(MediaServer, 2), MediaServer3(MediaServer, 3), 
    QoSDevice, QoSDevice2(QoSDevice, 2), QoSDevice3(QoSDevice, 3), RemoteUIDevice, RemoteUIServer, SolarProtectionBlind;
    
    private final DeviceType originalType;
    private final int version;
    private final String typeName;
    
    private DeviceType() {
        this(null, 1);
    }

    private DeviceType(DeviceType originalType, int version) {
        this.originalType = originalType;
        this.version = version;
        this.typeName = Serket.UPNP_DEVICE_URN_PREFIX + getDeviceName() + ":" + Integer.toString(version);
    }
 
    public final int getVersion() {
        return version;
    }
    
    public final String getDeviceName() {
        return originalType != null ? originalType.name() : name();
    }
    
    public final String getTypeName() {
        return typeName;
    }

}
