/*
 * Copyright 2009 Bradley Austin Davis
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
