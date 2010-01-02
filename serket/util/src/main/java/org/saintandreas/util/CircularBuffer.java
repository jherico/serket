package org.saintandreas.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

public class CircularBuffer<T> extends WrappedCollection<T, List<T>> implements Enumeration<T>{
    
    public CircularBuffer(Collection<T> source) {
        super(new ArrayList<T>(source));
    }

    private int index = 0;

    public synchronized boolean hasMoreElements() {
        return !inner.isEmpty();
    }

    public synchronized T nextElement() {
        if (++index >= inner.size()) {
            index = 0;
        }
        return inner.get(index);
    }

}
