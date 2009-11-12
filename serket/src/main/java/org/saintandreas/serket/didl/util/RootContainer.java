/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.didl.util;


/**
 * @author bdavis@saintandreas.org
 *
 */
public class RootContainer extends AContainer {

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

}
