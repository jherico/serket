/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.didl;

/**
 * @author bdavis@saintandreas.org
 * 
 */
public interface Desc extends Base {
    public String getMetaData();

    public String getType();

    public String getNamespace();
}
