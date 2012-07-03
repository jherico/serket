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
package org.saintandreas.serket.service;

import org.saintandreas.serket.Serket;

public enum ServiceType {
    // MS/MR 1
    AVTransport, ConnectionManager, ContentDirectory, RenderingControl,
    // MS/MR 2
    AVTransport2(AVTransport, 2), ConnectionManager2(ConnectionManager, 2), 
    ContentDirectory2(ContentDirectory, 2), RenderingControl2(RenderingControl, 2), ScheduledRecording,
    // MS 3
    ContentDirectory3(ContentDirectory, 3),
    // Security / Cameras
    SecurityConsole, SecurityCameraImage, SecuritCameraMotionImage, SecurityCameraSettings,
    // HVAC
    ControlValve, FanSpeed, HouseStatus, HVAC_FanMode, HVAC_SetpointSchedule, HVAC_UserOperatingMode,
    TemperatureSensor, TemperatureSetpoint, 
    // IGD
    LAN_HostConfigManagement, Layer3Forwarding, WAN_CableLinkConfig, WAN_CommonInterfaceConfig, WAN_SL_LinkConfig,
    WAN_EthernetLinkConfig, WAN_IP_Connection;

    private final int version;
    private final ServiceType originalType;
    private final String typeName;

    private ServiceType() {
        this(null, 1);
    }
    
    private ServiceType(ServiceType originalType, int version) {
        this.originalType = originalType;
        this.version = version;
        this.typeName = Serket.UPNP_SERVICE_URN_PREFIX + getServiceName() + ":" + Integer.toString(version);
    }
    
    public final int getVersion() {
        return version;
    }
    
    public final String getServiceName() {
        return originalType != null ? originalType.name() : name();
    }
    
    public final String getTypeName() {
        return typeName;
    }

    public final String scpdResourcePath() {
         return "/scpd/" + name() + ".xml";
    }
}
