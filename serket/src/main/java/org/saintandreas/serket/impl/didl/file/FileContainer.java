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
import java.util.ArrayList;
import java.util.List;

import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.didl.Container;
import org.w3c.dom.Node;

/**
 * @author bdavis@saintandreas.org
 *
 */
public class FileContainer extends FileNode implements Container {
    public static final String UPNP_OBJECT_CLASS = "object.container.storageFolder";

    protected List<FileNode> children = new ArrayList<FileNode>();
    protected long lastModified = -1;
    
    public FileContainer(File file) {
        super(file);
    }
    
//    @Override
//    public List<Base> getChildren() {
//        if (lastModified < file.lastModified()) {
//            refreshChildren();
//        }
//        return super.getChildren();
//    }

    
    private void refreshChildren() {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                addChild(new FileContainer(f));
            }
        }
    }

    @Override
    public Integer getChildCount() {
        return null;
    }

    @Override
    public String getCreateClass() {
        return null;
    }

    @Override
    public String getSearchClass() {
        return null;
    }

    @Override
    public Boolean isSearchable() {
        return null;
    }

    @Override
    public String getUpnpClass() {
        return UPNP_OBJECT_CLASS;
    }


}
