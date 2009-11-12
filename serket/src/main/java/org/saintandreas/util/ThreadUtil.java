/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.util;

/**
 * @author bdavis@saintandreas.org
 *
 */
public final class ThreadUtil {

    private ThreadUtil() {
    }

    public static void safeSleep(long millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { }
    }
    
}
