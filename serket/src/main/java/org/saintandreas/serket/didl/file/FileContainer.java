/*
 * Copyright 2009 Bradley Austin Davis
 */
package org.saintandreas.serket.didl.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.didl.util.AContainer;

/**
 * @author bdavis@saintandreas.org
 *
 */
public class FileContainer extends AContainer {

    private final File file;
    
    public FileContainer(File file) {
        this.file = file;
    }
    
    @Override
    public String getTitle() {
        return file.getName();
    }

    @Override
    public String getId()  {
        try {
            return "FILE$" + file.getCanonicalPath();
        } catch (IOException e) {
            LogFactory.getLog(getClass()).warn(e);
            throw new RuntimeException(e);
        }
    }

}
