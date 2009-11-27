package org.saintandreas.serket.reference.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.device.Device;
import org.saintandreas.serket.device.Icon;
import org.saintandreas.serket.service.Service;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@SuppressWarnings("serial")
public class DescriptionServlet extends HttpServlet {
    private Device rootDevice;

    public DescriptionServlet(Device device) {
        this.rootDevice = device;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogFactory.getLog(getClass()).debug("Got description request");
        response.setContentType("text/xml");
        response.getWriter().write(XmlUtil.formatXmlDocument(generateDocument(rootDevice)));
    }

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
        Node serviceNode = doc.createElement("service");
        XmlUtil.addChildElement(serviceNode, "serviceType", service.getServiceType());
        XmlUtil.addChildElement(serviceNode, "serviceId", service.getId());
        XmlUtil.addChildElement(serviceNode, "SCPDURL", service.getDescriptionURL());
        XmlUtil.addChildElement(serviceNode, "controlURL", service.getControlURL());
        XmlUtil.addChildElement(serviceNode, "evenSubURL", service.getEventURL());
        return serviceNode;
    }

}