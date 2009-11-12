/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.didl;

import java.util.List;

/**
 * @author bdavis@saintandreas.org
 * 
 */
public interface Container extends Node {
    public String getTitle();

    public List<Base> getChildren();

    public List<Base> getChildren(int offset, int count);

    public Integer getChildCount();

    public Boolean isSearchable();
}
