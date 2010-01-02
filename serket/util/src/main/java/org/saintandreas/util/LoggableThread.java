package org.saintandreas.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggableThread extends Thread{

    protected Logger getLog() {
        return LoggerFactory.getLogger(getClass());
    }
}
