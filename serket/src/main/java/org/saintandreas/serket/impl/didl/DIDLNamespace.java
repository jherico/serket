package org.saintandreas.serket.impl.didl;

public enum DIDLNamespace {
    DIDL("didl-lite", "urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/"), 
    DUBLIN("dc", "http://purl.org/dc/elements/1.1/"), 
    UPNP("upnp", "urn:schemas-upnp-org:metadata-1-0/upnp/"), 
    AV("av", "urn:schemas-upnp-org:av:av");

    String prefix;
    String uri;
    
    DIDLNamespace(String prefix, String uri) {
        this.prefix = prefix;
        this.uri = uri;
    }

}
