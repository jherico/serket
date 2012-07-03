package org.saintandreas.serket.impl.didl.file;

import java.io.File;

import org.saintandreas.serket.didl.types.Resource;
import org.saintandreas.serket.impl.didl.ItemImpl;
import org.saintandreas.serket.impl.didl.SerketContainer;

//<item id="0\AR\are\alb\tr789" parentID="0\AR\are\alb" restricted="true">
//  <dc:title>Ageing Had Never Been His Friend</dc:title>
//  <upnp:class>object.item.audioItem.musicTrack</upnp:class>
//  <upnp:artist>Love Is All</upnp:artist>
//  <upnp:album>Imagine The Shapes</upnp:album>
//  <upnp:genre>Alt/Punk</upnp:genre>
//  <dc:date>2007</dc:date>
//  <upnp:albumArtURI>http://172.21.139.222:59107/web/aa00a6a1c3</upnp:albumArtURI>
//  <upnp:blurbURI>http://172.21.139.222:59107/web/bl00a6a1c3</upnp:blurbURI>
//  <res protocolInfo="real.com-rhapsody-http-1-0:*:audio/x-ms-wma:*" size="2625408" duration="0:02:39">rhap://172.21.139.222:59107/web/tr00a6a1c3.wma</res>
//</item>


public abstract class FileItem extends ItemImpl {
    protected File file;
    
    public FileItem(SerketContainer<?> parent, File f) {
        super(parent);
        this.file = f;
    }
    
    @Override
    public String getTitle() {
        return file.getName();
    }

    @Override
    public String getLocalId() {
        return file.getName();
    }
//    <res protocolInfo="http-get:*:video/mp4:DLNA.ORG_OP=01" size="1053277590"
//        duration="02:31:21.920" resolution="640x480" bitrate="118656"
//        nrAudioChannels="2" sampleFrequency="44100">http://172.21.136.219:5001/get/0$0$0/2012.avi
//      </res>


    public Resource getResource() {
        return null;
    }
    
}
