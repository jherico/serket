package org.saintandreas.serket.impl.video;

import java.io.File;

public class VideoUtil {
    public static String [] EXTENSIONS = new String[] {
        "avi",
        "mkv",
        "m4v",
        "mp4",
    };
    
    
    public static boolean isVideoFileNameExtension(String ext) {
        for (String curExt : EXTENSIONS) {
            if (curExt.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVideoFileName(String name) {
        return name.contains(".") && isVideoFileNameExtension(name.substring(name.lastIndexOf('.') + 1).toLowerCase());
    }
    
    public static boolean isVideoFile(File f) {
        return isVideoFileName(f.getName());
    }
    
}
