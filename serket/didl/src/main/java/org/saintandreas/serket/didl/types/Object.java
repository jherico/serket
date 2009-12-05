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
/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.didl.types;

import org.saintandreas.serket.didl.annotations.DIDLAttribute;



/**
 * @author bdavis@saintandreas.org
 *
 */
public interface Object {
    @DIDLAttribute(value="id", required=true)
    public String getId();

}
