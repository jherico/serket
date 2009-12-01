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
package org.saintandreas.serket.impl.didl.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.didl.Container;
import org.saintandreas.serket.impl.didl.ContainerImpl;

/**
 * @author bdavis@saintandreas.org
 *
 */
public class FileContainer extends ContainerImpl<FileContainer> {
    public static final String UPNP_OBJECT_CLASS = "object.container.storageFolder";
    protected final File file;
    protected long lastModified = -1;
    
    public FileContainer(File file, Container parent) {
        super(parent);
        this.file = file;
    }

    @Override
    public String getUpnpClass() {
        return UPNP_OBJECT_CLASS;
    }

    @Override
    public String getTitle() {
        return file.getName();
    }

    @Override
    public String getId()  {
        try {
            return "FILE$" + file.getCanonicalPath();
        } catch (IOException e) {
            LogFactory.getLog(getClass()).warn(e);
            throw new RuntimeException(e);
        }
    }

        
    protected boolean refreshChildren() {
        boolean retVal = file.lastModified() > lastModified;
        if (retVal) {
            children.clear();
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    children.add(new FileContainer(f, this));
                }
            }
            lastModified = file.lastModified();
        }
        return retVal;
    }

}
