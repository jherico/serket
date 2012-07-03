package org.saintandreas.serket.didl;

import org.saintandreas.util.NamespaceContextHelper;

/**
 * This is an enum of all the 
 * @author bdavis@saintandreas.org
 *
 */
public enum DIDLNamespace {
    UPNP("upnp", "urn:schemas-upnp-org:metadata-1-0/upnp/", "http://www.upnp.org/schemas/av/upnp-v2.xsd"), 
    DIDL("didl-lite", "urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/", "http://www.upnp.org/schemas/av/didl-lite-v2.xsd"), 
    AV("av", "urn:schemas-upnp-org:av:av", "http://www.upnp.org/schemas/av/av-v2.xsd"),
    DUBLIN("dc", "http://purl.org/dc/elements/1.1/", "http://dublincore.org/schemas/xmls/qdc/dc.xsd"); 

    public static NamespaceContextHelper NS_CTX = new NamespaceContextHelper();
    static {
        for (DIDLNamespace ns : DIDLNamespace.values()) {
            NS_CTX.addMapping(ns.prefix, ns.uri);
        }
    }

    String prefix;
    String uri;
    String schemaLocation;
    DIDLNamespace(String prefix, String uri, String schemaLocation ) {
        this.prefix = prefix;
        this.uri = uri;
        this.schemaLocation = schemaLocation;
    }

}
