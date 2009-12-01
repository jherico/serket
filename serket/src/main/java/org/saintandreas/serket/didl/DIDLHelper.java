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
package org.saintandreas.serket.didl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author bdavis@saintandreas.org
 *
 */
public class DIDLHelper {
    private final static String ROOT_NODE_NAME = "DIDL-Lite";
    private static Map<Class<?>, AnnotatedClassInfo> ANNOTATION_MAP = new HashMap<Class<?>, AnnotatedClassInfo>();
    
    public static Node createNode(Object obj, Node parent)  {
        Class<?> ownerClass = obj.getClass();
        AnnotatedClassInfo info = null;
        if (!ANNOTATION_MAP.containsKey(ownerClass)) {
            synchronized (ANNOTATION_MAP) {
                if (!ANNOTATION_MAP.containsKey(ownerClass)) {
                    ANNOTATION_MAP.put(ownerClass, new AnnotatedClassInfo(ownerClass));
                }
            }
        }
        return ANNOTATION_MAP.get(ownerClass).createNode(obj, parent);
    }

    public static Document createDocument(Base item) {
        return createDocument(Arrays.asList(new Base[] { item }));
    }

    public static Document createDocument(List<Base> children) {
        Document retVal = XmlUtil.createDocument();
//        retVal.getDomConfig().setParameter("namespace-declarations", Boolean.FALSE);
        Element rootElement = retVal.createElementNS(DIDLNamespace.DIDL.uri, ROOT_NODE_NAME);
        
        for (DIDLNamespace ns : DIDLNamespace.values()) {
            rootElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:" + ns.prefix, ns.uri);
        }
        retVal.appendChild(rootElement);
        for (Base b : children) {
            rootElement.appendChild(createNode(b, rootElement));
        }
        return retVal;
    }

//    public static Element createElement(Base child, Document ownerDoc) {
//        Element retVal = null;
//        if (child instanceof Container) {
//            retVal = createContainerElement((Container) child, ownerDoc);
//        } else if (child instanceof Item) {
//            retVal = createItemElement((Item) child, ownerDoc);
//        } else if (child instanceof Desc) {
//            retVal = createDescElement((Desc) child, ownerDoc);
//        } else {
//            throw new RuntimeException("Unknown type of DLNAObject passed: " + child.getClass());
//        }
//        return retVal;
//    }

//    public static void setBaseElements(Element element, Base node) {
//        element.setAttribute("id", node.getId());
//        element.setAttribute("parentId", node.getParentId());
//        element.setAttribute("restricted", Boolean.toString(node.isRestricted()));
////        setElementAttributeIfNotNull(element, "neverPlayable", node.isNeverPlayable());
//    }
//
//    public static Element createContainerElement(Container child, Document ownerDoc) {
//        Element element = ownerDoc.createElement("container");
//        setBaseElements(element, child);
//        setElementAttributeIfNotNull(element, "searchable", child.isSearchable());
//        setElementAttributeIfNotNull(element, "searchable", child.getChildCount());
//        return element;
//    }
//
//    private static<T> void setElementAttributeIfNotNull(Element element, String name, Object value) {
//        if (value != null) {
//            element.setAttribute(name, value.toString());
//        }
//    }
//
//    public static Element createItemElement(Item child, Document ownerDoc) {
//        Element retVal = ownerDoc.createElement("item");
//        setBaseElements(retVal, child);
//        return retVal;
//    }
//
//    public static Element createDescElement(Desc child, Document ownerDoc) {
//        Element retVal = ownerDoc.createElement("desc");
//        return retVal;
//    }


}
//<DIDL-Lite>
//<item id="0$1$1$0" parentID="0$1$1" restricted="true">
//<dc:title>JET FM (French Radio) [MPlayer Web]</dc:title>
//<res protocolInfo="http-get:*:audio/wav:DLNA.ORG_PN=LPCM;DLNA.ORG_OP=01" size="100000000000">http://192.168.0.102:5001/get/0$1$1$0/JET+FM+%28French+Radio%29</res>
//<upnp:albumArtURI profileID="JPEG_TN">http://192.168.0.102:5001/get/0$1$1$0/thumbnail0000JET+FM+%28French+Radio%29</upnp:albumArtURI>
//<upnp:class>object.item.audioItem.musicTrack</upnp:class>
//</item>
//<container id="0$1$1$1" childCount="1" parentID="0$1$1" restricted="true">
//<dc:title>Radios With VLC</dc:title>
//<res protocolInfo="http-get:*:image/jpeg:DLNA.ORG_PN=JPEG_TN">http://192.168.0.102:5001/get/0$1$1$1/thumbnail0000Radios+With+VLC+%5Bvlcaudio%5D</res>
//<upnp:class>object.container.storageFolder</upnp:class>
//</container>
//<item id="0$1$1$2" parentID="0$1$1" restricted="true">
//<dc:title>Smooth Jazz [MPlayer Web]</dc:title>
//<res protocolInfo="http-get:*:audio/wav:DLNA.ORG_PN=LPCM;DLNA.ORG_OP=01" size="100000000000">http://192.168.0.102:5001/get/0$1$1$2/Smooth+Jazz</res>
//<upnp:albumArtURI profileID="JPEG_TN">http://192.168.0.102:5001/get/0$1$1$2/thumbnail0000Smooth+Jazz</upnp:albumArtURI>
//<upnp:class>object.item.audioItem.musicTrack</upnp:class>
//</item>
//<item id="0$1$1$3" parentID="0$1$1" restricted="true">
//<dc:title>KBPS All-classical [MPlayer Web]</dc:title>
//<res protocolInfo="http-get:*:audio/wav:DLNA.ORG_PN=LPCM;DLNA.ORG_OP=01" size="100000000000">http://192.168.0.102:5001/get/0$1$1$3/KBPS+All-classical</res>
//<upnp:albumArtURI profileID="JPEG_TN">http://192.168.0.102:5001/get/0$1$1$3/thumbnail0000KBPS+All-classical</upnp:albumArtURI>
//<upnp:class>object.item.audioItem.musicTrack</upnp:class>
//</item>
//</DIDL-Lite>
