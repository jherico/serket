package org.saintandreas.util;

import java.util.Collection;
import java.util.Iterator;

public abstract class WrappedCollection<T, C extends Collection<T>> implements Collection<T>{
    protected final C inner;

    public WrappedCollection(C source) {
        inner = source;
    }

    
    public synchronized boolean add(T e) {
        return inner.add(e);
    }

    
    public synchronized boolean addAll(Collection<? extends T> c) {
        return inner.addAll(c);
    }

    
    public synchronized void clear() {
        inner.clear();
       
    }

    
    public synchronized boolean contains(Object o) {
        return inner.contains(o);
    }

    
    public synchronized boolean containsAll(Collection<?> c) {
        return inner.containsAll(c);
    }

    
    public synchronized boolean isEmpty() {
        return inner.isEmpty();
    }

    
    public synchronized Iterator<T> iterator() {
        return inner.iterator();
    }

    
    public synchronized boolean remove(Object o) {
        return inner.remove(o);
    }

    
    public boolean removeAll(Collection<?> c) {
        return inner.removeAll(c);
    }

    
    public boolean retainAll(Collection<?> c) {
        return inner.retainAll(c);
    }

    
    public int size() {
        return inner.size();
    }

    
    public Object[] toArray() {
        return inner.toArray();
    }

    
    public <X> X[] toArray(X[] a) {
        return inner.toArray(a);
    }
}
