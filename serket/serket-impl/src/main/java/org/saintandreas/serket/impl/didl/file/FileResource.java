package org.saintandreas.serket.impl.didl.file;

import java.io.File;

import org.saintandreas.serket.impl.didl.ItemImpl;
import org.saintandreas.serket.impl.didl.SerketContainer;

public class FileResource extends ItemImpl {
    private File file;
    
    public FileResource(SerketContainer<?> parent, File f) {
        super(parent);
        this.file = f;
    }
}
