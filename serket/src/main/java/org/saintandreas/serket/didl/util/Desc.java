/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.didl.util;


/**
 * @author bdavis@saintandreas.org
 *
 */
public class Desc implements org.saintandreas.serket.didl.Desc {
    private String id;
    private String metaData;
    private String type;
    private String namespace;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getMetaData() {
        return metaData;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getNamespace() {
        return namespace;
    }

}
