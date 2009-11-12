/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.didl.util;

import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.didl.Node;

/**
 * @author bdavis@saintandreas.org
 *
 */
public abstract class ANode implements Node {

    private Base parent = null;
    
    @Override
    public String getParentId() {
        return getParent().getId();
    }

    @Override
    public boolean isRestricted() {
        return true;
    }

    @Override
    public Boolean isNeverPlayable() {
        return null;
    }

    public Base getParent() {
        return parent;
    }

    public void setParent(Base parent) {
        this.parent = parent;
    }

}
