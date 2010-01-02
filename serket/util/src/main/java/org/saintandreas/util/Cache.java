package org.saintandreas.util;

import java.io.IOException;

public interface Cache<T, K> {
    public static class NullCache<T, K> implements Cache<T, K> {
        public void cacheItem(K key, T item) throws IOException {
        }

        public T getCachedItem(K key){
            return null;
        }
    }
    
    public void cacheItem(K key, T item) throws IOException;
    public T getCachedItem(K key);
}
