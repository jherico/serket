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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.saintandreas.serket.didl.Container;
import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.didl.Desc;
import org.saintandreas.util.CollectionUtil;

/**
 * @author bdavis@saintandreas.org
 * 
 */
public abstract class AContainer extends ANode implements Container {
    private static final String UPNP_OBJECT_CLASS = "object.container.storageFolder";

    private List<Base> children = new ArrayList<Base>();

    public String getUpnpClass() {
        return UPNP_OBJECT_CLASS;
    }

    @Override
    public Integer getChildCount() {
        return children.size();
    }

    public void addChild(ANode newChild) {
        newChild.setParent(this);
        children.add(newChild);
    }

    public void addChild(Desc newChild) {
        children.add(newChild);
    }

    @Override
    public List<Base> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public List<Base> getChildren(int offset, int count) {
        return CollectionUtil.getSubList(offset, count, children);
    }

    @Override
    public Boolean isSearchable() {
        return null;
    }

}
