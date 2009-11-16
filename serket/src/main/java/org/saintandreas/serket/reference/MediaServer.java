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
package org.saintandreas.serket.reference;

import org.saintandreas.serket.Serket;
import org.saintandreas.serket.device.DeviceType;
import org.saintandreas.serket.device.Manufacturer;
import org.saintandreas.serket.device.Model;
import org.saintandreas.serket.impl.BaseDevice;
import org.saintandreas.util.NetUtil;

public class MediaServer extends BaseDevice {
    
    private static class SerketModel implements Model {

        @Override
        public String getDescription() {
            return "Serket Media Server reference implementation";
        }

        @Override
        public String getName() {
            return "Serket AV Server";
        }

        @Override
        public String getNumber() {
            return Serket.VERSION;
        }

        @Override
        public String getUPC() {
            return null;
        }

        @Override
        public String getURL() {
            return null;
        }
        
    }
    
    private static class SerketManufacturer implements Manufacturer {
        @Override
        public String getName() {
            return "Saint Andreas";
        }
        @Override
        public String getURL() {
            return Serket.PROJECT_URL;
        }
    }

    public MediaServer(String UDN, String presentationURL) {
        super("Serket AV " + NetUtil.getHostname(), UDN, "software", presentationURL, new SerketManufacturer(), new SerketModel());
    }
    

    @Override
    public DeviceType getDeviceTypeEnum() {
        return DeviceType.MediaServer3;
    }

}