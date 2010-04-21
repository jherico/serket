package org.saintandreas.serket.didl.types.video;

import org.saintandreas.serket.didl.DIDLNamespace;
import org.saintandreas.serket.didl.annotations.DIDLProperty;
import org.saintandreas.serket.didl.types.Item;

public interface VideoBroadcast extends Item {
    @DIDLProperty(value="genre", namespace=DIDLNamespace.UPNP)
    public String getGenre();

    @DIDLProperty(value="longDescription", namespace=DIDLNamespace.UPNP)
    public String getLongDescription();

    @DIDLProperty(value="producer", namespace=DIDLNamespace.UPNP)
    public String getProducer();

//    @DIDLProperty(value="rating", namespace=DIDLNamespace.UPNP)
//    @DIDLProperty(value="actor", namespace=DIDLNamespace.UPNP)
//    @DIDLProperty(value="director", namespace=DIDLNamespace.UPNP)

    @DIDLProperty(value="description", namespace=DIDLNamespace.DUBLIN)
    public String getDescription();

    @DIDLProperty(value="publisher", namespace=DIDLNamespace.DUBLIN)
    public String getPublisher();


    @DIDLProperty(value="language", namespace=DIDLNamespace.DUBLIN)
    public String getLanguage();

    @DIDLProperty(value="relation", namespace=DIDLNamespace.DUBLIN)
    public String getRelation();


}
