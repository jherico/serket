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

import java.util.ArrayList;
import java.util.List;

import org.saintandreas.serket.impl.didl.file.FileContainer;
import org.saintandreas.serket.scpd.ContentDirectory.BrowseRequest;


/**
 * @author bdavis@saintandreas.org
 *
 */
public class RootContainer extends ContainerImpl {

    private volatile int updateId = 1; 

    public RootContainer() {
        super(null);
    }

    @Override
    public String getId() {
        return "0";
    }

    @Override
    public String getParentId() {
        return "-1";
    }

    @Override
    public String getTitle() {
        return "Root";
    }

    public int getUpdateId() {
        return updateId;
    }

    @Override
    public String getUpnpClass() {
        return FileContainer.UPNP_OBJECT_CLASS;
    }
    
    public List<BaseImpl> getChildren() {
        return children;
    }

    @Override
    public List<? extends org.saintandreas.serket.didl.Base> getChildren(BrowseRequest request) {
        return children;
    }

    @Override
    protected void refreshChildren() {
    }
}
