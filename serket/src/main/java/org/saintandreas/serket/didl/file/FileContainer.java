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
package org.saintandreas.serket.didl.file;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.didl.util.AContainer;

/**
 * @author bdavis@saintandreas.org
 *
 */
public class FileContainer extends AContainer {

    private final File file;
    private long lastModified;
    
    public FileContainer(File file) {
        this.file = file;
        lastModified = -1;
    }
    
    @Override
    public List<Base> getChildren() {
        if (lastModified < file.lastModified()) {
            refreshChildren();
        }
        return super.getChildren();
    }

    
    private void refreshChildren() {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                addChild(new FileContainer(f));
            }
        }
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

}
