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

import java.util.ArrayList;
import java.util.List;

/**
 * @author bdavis@saintandreas.org
 *
 */
public final class CollectionUtil {
    private CollectionUtil() {
    }
    
    public static<T> List<T> getSubList(int offset, int count, List<T> originalList) {
        List<T> retVal = new ArrayList<T>(originalList);
        truncateList(offset, count, retVal);
        return retVal;
    }

    public static<T> void truncateList(int offset, int count, List<T> originalList) {
        List<T> retVal = new ArrayList<T>(originalList);
        // find 
        if (offset > 0) {
            if (offset < retVal.size()) {
                retVal.subList(0, offset).clear();
            }
        }
        // truncate
        if (count > 0 && count < retVal.size()) {
            retVal.subList(count, retVal.size()).clear();
        }
    }
}
