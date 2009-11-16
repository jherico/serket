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
package org.saintandreas.serket.util;

import java.util.List;

import org.saintandreas.serket.device.Device;
import org.saintandreas.serket.device.Icon;
import org.saintandreas.serket.service.Service;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DescriptionUtil {

    public static final Document generateDocument(Device rootDevice) {
        Node n;
        Document document = XmlUtil.createDocument();
        document.appendChild(n = document.createElementNS("urn:schemas-upnp-org:device-1-0", "root"));
        n.appendChild(n = document.createElement("specVersion"));
        XmlUtil.addChildElement(n, "major", "1");
        XmlUtil.addChildElement(n, "minor", "1");
        n.appendChild(createDeviceNode(rootDevice, document));
        return document;
    }

    public static Node createDeviceListNode(List<Device> list, Document doc) {
        Node n = doc.createElement("deviceList");
        for (Device service : list) {
            n.appendChild(createDeviceNode(service, doc));
        }
        return n;
    }

    public static Node createDeviceNode(Device device, Document doc) {
        Node n = doc.createElement("device");
        XmlUtil.addChildElement(n, "deviceType", device.getDeviceType());
        XmlUtil.addChildElement(n, "friendlyName", device.getFriendlyName());
        XmlUtil.addChildElement(n, "manufacturer", device.getManufacturer().getName());
        XmlUtil.addChildElementIfNotNull(n, "manufacturerURL", device.getManufacturer().getURL());
        XmlUtil.addChildElementIfNotNull(n, "manufacturerURL", device.getManufacturer().getURL());
        XmlUtil.addChildElementIfNotNull(n, "modelDescription", device.getModel().getDescription());
        XmlUtil.addChildElementIfNotNull(n, "modelName", device.getModel().getName());
        XmlUtil.addChildElementIfNotNull(n, "modelNumber", device.getModel().getNumber());
        XmlUtil.addChildElementIfNotNull(n, "modelURL", device.getModel().getURL());
        XmlUtil.addChildElementIfNotNull(n, "serialNumber", device.getSerialNumber());
        XmlUtil.addChildElement(n, "UDN", device.getUDN());
        if (device.getIconList().size() > 0) {
            n.appendChild(createIconListNode(device.getIconList(), doc));
        }
        if (device.getServiceList().size() > 0) {
            n.appendChild(createServiceListNode(device.getServiceList(), doc));
        }
        if (device.getDeviceList().size() > 0) {
            n.appendChild(createDeviceListNode(device.getDeviceList(), doc));
        }
        return n;
    }

    public static Node createIconListNode(List<Icon> list, Document doc) {
        Node n = doc.createElement("iconList");
        for (Icon icon : list) {
            n.appendChild(createIconNode(icon, doc));
        }
        return n;
    }

    public static Node createIconNode(Icon icon, Document doc) {
        Element iconNode = doc.createElement("icon");
        XmlUtil.addChildElement(iconNode, "mimetype", icon.getMimeType());
        XmlUtil.addChildElement(iconNode, "width", Integer.toString(icon.getWidth()));
        XmlUtil.addChildElement(iconNode, "height", Integer.toString(icon.getHeight()));
        XmlUtil.addChildElement(iconNode, "depth", Integer.toString(icon.getDepth()));
        XmlUtil.addChildElement(iconNode, "url", Integer.toString(icon.getDepth()));
        return iconNode;
    }

    public static Node createServiceListNode(List<Service> list, Document doc) {
        Node n = doc.createElement("serviceList");
        for (Service service : list) {
            n.appendChild(createServiceNode(service, doc));
        }
        return n;
    }
    
    public static Node createServiceNode(Service service, Document doc) {
        Node serviceNode = doc.createElement("icon");
        XmlUtil.addChildElement(serviceNode, "serviceType", service.getServiceType());
        XmlUtil.addChildElement(serviceNode, "serviceId", service.getId());
        XmlUtil.addChildElement(serviceNode, "SCPDURL", service.getDescriptionURL());
        XmlUtil.addChildElement(serviceNode, "controlURL", service.getControlURL());
        XmlUtil.addChildElement(serviceNode, "evenSubURL", service.getEventURL());
        return serviceNode;
    }

}
