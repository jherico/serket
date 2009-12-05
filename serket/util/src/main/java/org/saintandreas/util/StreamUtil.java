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
