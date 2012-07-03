package org.saintandreas.serket.impl.didl.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.saintandreas.serket.didl.DIDLNamespace;
import org.saintandreas.serket.didl.annotations.DIDLProperty;
import org.saintandreas.serket.didl.types.Resource;
import org.saintandreas.serket.didl.types.video.VideoItem;
import org.saintandreas.serket.impl.didl.ResourceImpl;
import org.saintandreas.serket.impl.didl.SerketContainer;

public class VideoFileItem extends FileItem implements VideoItem{

    protected Resource resource;
    private class Resource extends ResourceImpl {
        @Override
        public String getProtocolInfo() {
            // TODO Auto-generated method stub
            return "http-get:*:video/mp4:DLNA.ORG_OP=01";
        }

        @Override
        public String getText() {
            return "http://foo.bar.baz/foo.bar.baz";
        }
    }

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public VideoFileItem(SerketContainer<?> parent, File f) {
        super(parent, f);
        resource = new Resource();
    }

    @DIDLProperty(value="date", namespace=DIDLNamespace.DUBLIN)
    //     <dc:date>2010-02-25T11:34:48</dc:date>
    public String getDate() {
        return new SimpleDateFormat(DATE_FORMAT).format(new Date(file.lastModified()));
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getGenre() {
        return null;
    }

    @Override
    public String getLanguage() {
        return null;
    }

    @Override
    public String getLongDescription() {
        return null;
    }

    @Override
    public String getProducer() {
        return null;
    }

    @Override
    public String getPublisher() {
        return null;
    }

    @Override
    public String getRelation() {
        return null;
    }

    @Override
    public String getUpnpClass() {
        return "object.item.videoItem";
    }

    @Override
    public Resource getRes() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
