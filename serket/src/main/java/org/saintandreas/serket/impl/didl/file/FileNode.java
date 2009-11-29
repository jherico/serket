package org.saintandreas.serket.impl.didl.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.saintandreas.serket.impl.didl.Base;

public abstract class FileNode extends Base {
    protected final File file;
    protected final List<String> res = new ArrayList<String>();
    
    
    public FileNode(File file) {
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

