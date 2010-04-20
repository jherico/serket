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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.impl.didl.AContainerImpl;
import org.saintandreas.serket.impl.didl.SerketBase;
import org.saintandreas.serket.impl.didl.SerketContainer;
import org.saintandreas.serket.impl.video.VideoUtil;

/**
 * @author bdavis@saintandreas.org
 * 
 */
public class FileContainer extends AContainerImpl<SerketBase> {
    private final static Log LOG = LogFactory.getLog(FileContainer.class); 
    protected final File file;
    protected long lastModified = -1;
    
    public FileContainer(SerketContainer<?> parent, File file) {
        super(parent);
        this.file = file;
        
    }
    
    @Override
    public Integer getChildCount() {
        return null;
    }

    @Override
    public String getTitle() {
        return file.getName();
    }

    @Override
    public String getLocalId() {
        return file.getName();
    }


    public boolean refreshChildren() {
        boolean retVal = file.lastModified() > lastModified; 
        if (retVal) {
            if (LOG.isTraceEnabled()) LOG.trace("refreshing children of " + getId());
            clearChildren();
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    addChild(new FileContainer(this, f));
                } else if (VideoUtil.isVideoFile(f)) {
                    
                }
            }
            lastModified = file.lastModified();
        }
        if (retVal) {
            increment();
        }
        return retVal;
    }



}
