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
package org.saintandreas.serket.didl.util;

import java.io.IOException;
import java.util.List;

import org.saintandreas.serket.didl.Container;
import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.didl.Desc;
import org.saintandreas.serket.didl.Item;
import org.saintandreas.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author bdavis@saintandreas.org
 *
 */
public class DIDLHelper {
    public final static String DIDL_LITE_NAMESPACE_URI = "urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/";
    public final static String DUBLIN_CORE_NAMESPACE_URI = "http://purl.org/dc/elements/1.1/";
    public final static String UPNP_NAMESPACE_URI = "http://purl.org/dc/elements/1.1/";
    private final static String ROOT_NODE_NAME = "DIDL-Lite";

    //    <DIDL-Lite xmlns="urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/" xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:upnp="urn:schemas-upnp-org:metadata-1-0/upnp/">
    //     ..
    //    </DIDL-Lite>

    public static String format(List<Base> children) throws IOException {
        return XmlUtil.formatXmlDocument(createDocument(children));
    }

    public static Document createDocument(List<Base> children) {
        Document retVal = XmlUtil.createDocument();
        Element rootElement = retVal.createElementNS(DIDL_LITE_NAMESPACE_URI, "DIDL-Lite");
        retVal.appendChild(rootElement);
        for (Base child : children) {
            retVal.getDocumentElement().appendChild(createElement(child, retVal));
        }
        return retVal;
    }

    //  private String id;
    //  private String parentId;
    //  private boolean restricted = true;
    //  private Boolean neverPlayable = null;
    //
    //  protected abstract Element createElement(Document parentDoc);
    //  
    //  @Override
    //  public Element toDomNode(Document parentDoc) {
    //  }

    public static Element createElement(Base child, Document ownerDoc) {
        Element retVal = null;
        if (child instanceof Container) {
            retVal = createContainerElement((Container) child, ownerDoc);
        } else if (child instanceof Item) {
            retVal = createItemElement((Item) child, ownerDoc);
        } else if (child instanceof Desc) {
            retVal = createDescElement((Desc) child, ownerDoc);
        } else {
            throw new RuntimeException("Unknown type of DLNAObject passed: " + child.getClass());
        }
        return retVal;
    }

    public static void setNodeElements(Element element, org.saintandreas.serket.didl.Node node) {
        element.setAttribute("id", node.getId());
        element.setAttribute("parentId", node.getParentId());
        element.setAttribute("restricted", Boolean.toString(node.isRestricted()));
        setElementAttributeIfNotNull(element, "neverPlayable", node.isNeverPlayable());
    }

    public static Element createContainerElement(Container child, Document ownerDoc) {
        Element element = ownerDoc.createElement("container");
        setNodeElements(element, child);
        setElementAttributeIfNotNull(element, "searchable", child.isSearchable());
        setElementAttributeIfNotNull(element, "searchable", child.getChildCount());
        return element;
    }

    private static<T> void setElementAttributeIfNotNull(Element element, String name, Object value) {
        if (value != null) {
            element.setAttribute(name, value.toString());
        }
    }

    public static Element createItemElement(Item child, Document ownerDoc) {
        Element retVal = ownerDoc.createElement("item");
        setNodeElements(retVal, child);
        return retVal;
    }

    public static Element createDescElement(Desc child, Document ownerDoc) {
        Element retVal = ownerDoc.createElement("desc");
        return retVal;
    }


}
