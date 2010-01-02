package org.saintandreas.util;
import java.io.File;
import java.io.IOException;

import org.slf4j.LoggerFactory;


public class SimpleFileCache implements Cache<String, String>{
    private final File rootFolder;
    
    public SimpleFileCache(File root ) {
        this.rootFolder = root;
    }

    protected File getTarget(String key, boolean create) {
        File retVal = new File(rootFolder, key);
        if (create) {
            retVal.getParentFile().mkdirs();
        }
        return retVal; 
    }

    public void cacheItem(String key, String item) throws IOException {
        StringUtil.writeToFile(item, getTarget(key, true));
    }

    public String getCachedItem(String key) {
        String retVal = null;
        File target = getTarget(key,false);
        if (target.exists()) {
            try {
                retVal = StringUtil.readFromFile(target);
            } catch (IOException e) {
                LoggerFactory.getLogger(getClass()).warn("", e);
            }
        }
        return retVal;
    }

}
