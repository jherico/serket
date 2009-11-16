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
package org.saintandreas.serket.didl.util;

import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.didl.Node;

/**
 * @author bdavis@saintandreas.org
 *
 */
public abstract class ANode implements Node {

    private Base parent = null;
    
    @Override
    public String getParentId() {
        return getParent().getId();
    }

    @Override
    public boolean isRestricted() {
        return true;
    }

    @Override
    public Boolean isNeverPlayable() {
        return null;
    }

    public Base getParent() {
        return parent;
    }

    public void setParent(Base parent) {
        this.parent = parent;
    }

}
