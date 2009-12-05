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
package org.saintandreas.serket.impl.didl;

import java.util.ArrayList;
import java.util.List;

import org.saintandreas.serket.impl.didl.event.SerketEvent;
import org.saintandreas.serket.impl.didl.event.SerketEventListener;

/**
 * @author bdavis@saintandreas.org
 *
 */
public abstract class BaseImpl implements SerketBase {
    private SerketContainer<?> parent = null;
    private String cachedId = null;
    private List<SerketEventListener> listeners = new ArrayList<SerketEventListener>();


    @SuppressWarnings("unchecked")
    public BaseImpl(SerketContainer parent) {
        this.parent = parent;
    }
    
    public String getParentID() {
        return getParent().getId();
    }

    public SerketContainer<?> getParent() {
        return parent;
    }
    
    public final String getId() {
        if (getParent() != null) {
            if (cachedId == null) {
                cachedId = getParentID() + "/" + getLocalId();
            }
            return cachedId;
        }
        return getLocalId();
    }
    
    @Override
    public void addListener(SerketEventListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeListener(SerketEventListener listener) {
        this.listeners.remove(listener);
    }

    public void sendEvent(SerketEvent serketEvent) {
        for (SerketEventListener listener : listeners) {
            listener.onEvent(serketEvent);
        }
    }

    
    
}
