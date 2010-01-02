package org.saintandreas.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Loggable {

    protected Logger getLog() {
        return LoggerFactory.getLogger(getClass());
    }
}
