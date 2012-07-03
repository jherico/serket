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
package org.saintandreas.serket.impl.didl.misc;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.didl.types.Object;
import org.saintandreas.serket.impl.didl.AContainerImpl;
import org.saintandreas.serket.impl.didl.SerketBase;
import org.saintandreas.serket.impl.didl.SerketContainer;
import org.saintandreas.serket.impl.didl.event.SerketEvent;
import org.saintandreas.serket.impl.didl.file.FileContainer;


/**
 * @author bdavis@saintandreas.org
 *
 */
public class RootContainer extends AContainerImpl<SerketBase> {
    private final static Log LOG = LogFactory.getLog(FileContainer.class); 

    private Map<String, SerketBase> masterMap = new HashMap<String, SerketBase>();

    public RootContainer() {
        super(null);
        masterMap.put("0", this);
    }

    @Override
    public String getLocalId() {
        return "0";
    }

    @Override
    public String getParentID() {
        return "-1";
    }

    @Override
    public String getTitle() {
        return "Root";
    }

    public SerketBase findById(String id) {
        return masterMap.get(id);
    }
    
    @Override
    public boolean refreshChildren() {
        boolean retVal = false;
        for (Object child : getChildren()) {
            if (child instanceof SerketContainer<?>) {
                retVal |= ((SerketContainer<?>)child).refreshChildren();
            }
        }
        if (retVal) {
            increment();
        }
        return retVal;
    }

    @Override
    public void addChild(SerketBase child) {
        super.addChild(child);
        this.masterMap.put(child.getId(), child);
    }
    
    @Override
    public synchronized void onEvent(SerketEvent event) {
        switch (event.type) {
        case OBJECT_ADDED:
            if (masterMap.containsKey(event.getSerketBase().getId())) {
                throw new RuntimeException("attempted to add existing child " + event.getSerketBase().getId());
            }
            if (LOG.isTraceEnabled()) LOG.trace("adding " + event.getSerketBase().getId());
            masterMap.put(event.getSerketBase().getId(), event.getSerketBase());
            break;

        case OBJECT_REMOVED:
            if (!masterMap.containsKey(event.getSerketBase().getId())) {
                throw new RuntimeException("attempted to remove unknown child" + event.getSerketBase().getId());
            }
            if (LOG.isTraceEnabled()) LOG.trace("removing " + event.getSerketBase().getId());
            masterMap.remove(event.getSerketBase().getId());
            break;

        case OBJECT_CHANGED:
            break;
        }
    }

}
