/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.LogFactory;

/**
 * @author bdavis@saintandreas.org
 *
 */
public final class StreamUtil {
    private StreamUtil() {
    }

    public static InputStream getResourceAsStream(String resource) {
        if (!resource.startsWith("/")) {
            resource = resource + "/";
        }
        return StreamUtil.class.getResourceAsStream(resource);
    }

    public static void safeClose(Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
            } catch (IOException e) {
                // log it & eat it
                LogFactory.getLog(StreamUtil.class).warn(e);
            }
        }
    }

}
