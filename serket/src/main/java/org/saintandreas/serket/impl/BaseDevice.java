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
package org.saintandreas.serket.impl;

import java.util.ArrayList;
import java.util.List;

import org.saintandreas.serket.device.Device;
import org.saintandreas.serket.device.DeviceType;
import org.saintandreas.serket.device.Icon;
import org.saintandreas.serket.device.Manufacturer;
import org.saintandreas.serket.device.Model;
import org.saintandreas.serket.service.Service;

public abstract class BaseDevice implements Device {
    public abstract DeviceType getDeviceTypeEnum();

    private final String friendlyName;
    private final String UDN;
    private final String serialNumber;
    private final String presentationURL;
    private final Model model;
    private final Manufacturer manufacturer;
    private final List<Icon> iconList = new ArrayList<Icon>();
    private final List<Service> serviceList = new ArrayList<Service>();
    private final List<Device> deviceList = new ArrayList<Device>();

    protected BaseDevice(String friendlyName, String UDN, String serialNumber, String presentationURL, Manufacturer manufacturer, Model model) {
        this.friendlyName = friendlyName;
        this.UDN = UDN;
        this.serialNumber = serialNumber;
        this.presentationURL = presentationURL;
        this.model = model;
        this.manufacturer = manufacturer;
    }

    @Override
    public final Manufacturer getManufacturer() {
        return manufacturer;
    }

    @Override
    public final Model getModel() {
        return model;
    }

    @Override
    public String getDeviceType() {
        return getDeviceTypeEnum().getTypeName();
    }

    @Override
    public List<Icon> getIconList() {
        return iconList;
    }

    @Override
    public List<Service> getServiceList() {
        return serviceList;
    }

    @Override
    public List<Device> getDeviceList() {
        return deviceList;
    }

    @Override
    public String getFriendlyName() {
        return friendlyName;
    }

    @Override
    public String getPresentationURL() {
        return presentationURL;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String getUDN() {
        return UDN;
    }

}
