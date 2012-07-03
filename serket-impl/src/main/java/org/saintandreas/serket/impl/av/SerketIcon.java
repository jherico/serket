package org.saintandreas.serket.impl.av;

import org.saintandreas.serket.device.Icon;

public class SerketIcon implements Icon {
    
    private final int depth;
    private final int height;
    private final int width;
    private final String mimeType;
    private final String url;
    
    public SerketIcon(String mimeType, String url, int width, int height, int depth) {
        this.mimeType = mimeType;
        this.url = url;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public int getDepth() {
        // TODO Auto-generated method stub
        return depth;
    }

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return width;
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return height;
    }

    @Override
    public String getMimeType() {
        // TODO Auto-generated method stub
        return mimeType;
    }

    @Override
    public String getURL() {
        // TODO Auto-generated method stub
        return url;
    }

}
