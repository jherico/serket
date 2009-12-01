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
/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.didl;



/**
 * @author bdavis@saintandreas.org
 *
 */
public interface Base {
    @DIDLAttribute(value="id", required=true)
    public String getId();

    @DIDLAttribute(value="parentID", required=true)
    public String getParentID();

    @DIDLAttribute(value="restricted", required=true)
    public boolean isRestricted();

    @DIDLAttribute("neverPlayable")
    public Boolean isNeverPlayable();

    @DIDLElement(value="title", namespace=DIDLNamespace.DUBLIN, required=true, order=0)
    public String getTitle();

    @DIDLElement(value="class", namespace=DIDLNamespace.UPNP, required=true, order=1)
    public String getUpnpClass();
}
