/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.didl;

/**
 * @author bdavis@saintandreas.org
 *
 */
public interface Node extends Base {
    public String getParentId();

    public boolean isRestricted();

    public Boolean isNeverPlayable();

    public String getUpnpClass();

}
