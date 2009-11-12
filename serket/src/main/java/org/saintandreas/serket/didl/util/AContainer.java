/*
 * Copyright 2009 Bradley Austin Davis
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
