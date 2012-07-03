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
package org.saintandreas.serket.didl.types;

import org.saintandreas.serket.didl.DIDLNamespace;
import org.saintandreas.serket.didl.annotations.DIDLAttribute;
import org.saintandreas.serket.didl.annotations.DIDLElement;
import org.saintandreas.serket.didl.annotations.DIDLProperty;



/**
 * @author bdavis@saintandreas.org
 * 
 */
@DIDLElement("container")
public interface Container extends Object {
    public static final String UPNP_OBJECT_CLASS = "object.container";

    @DIDLAttribute(value="parentID", required=true)
    public String getParentID();

    @DIDLAttribute(value="restricted", required=true)
    public boolean isRestricted();

    @DIDLAttribute("neverPlayable")
    public Boolean isNeverPlayable();

    @DIDLProperty(value="title", namespace=DIDLNamespace.DUBLIN, required=true, order=0)
    public String getTitle();

    @DIDLProperty(value="class", namespace=DIDLNamespace.UPNP, required=true, order=1)
    public String getUpnpClass();

    @DIDLAttribute("searchable")
    public Boolean isSearchable();

    @DIDLAttribute("childCount")
    public Integer getChildCount();
}
