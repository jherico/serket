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
package org.saintandreas.serket.impl.didl;

import java.lang.reflect.InvocationTargetException;

import org.w3c.dom.Node;

/**
 * @author bdavis@saintandreas.org
 *
 */
public abstract class BaseImpl implements org.saintandreas.serket.didl.Base {

    private ContainerImpl parent = null;

    public BaseImpl(ContainerImpl parent) {
        this.parent= parent;
    }
    
    @DIDLAttribute(name = "id")
    public abstract String getId();

    @DIDLElement(name = "class", namespace = DIDLNamespace.UPNP)
    public abstract String getUpnpClass();
    
    @DIDLElement(name = "title", namespace = DIDLNamespace.DUBLIN)
    public abstract String getTitle();
    
    @DIDLElement(name = "date", namespace = DIDLNamespace.DUBLIN, required = false)
    public String getDate() {
        return null;
    }

    @DIDLAttribute(name = "parentId")
    public String getParentId() {
        return getParent().getId();
    }

    public ContainerImpl getParent() {
        return parent;
    }

    public void setParent(ContainerImpl parent) {
        this.parent = parent;
    }
    
    @Override
    public Node formatAsNode(Node parent) {
        try {
            return DIDLHelper.createNode(this, parent);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        } catch (InvocationTargetException e) {
            throw new RuntimeException();
        }
    }


}
