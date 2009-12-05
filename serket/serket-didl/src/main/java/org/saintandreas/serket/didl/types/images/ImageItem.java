package org.saintandreas.serket.didl.types.images;

import java.util.Date;

import org.saintandreas.serket.didl.DIDLNamespace;
import org.saintandreas.serket.didl.annotations.DIDLProperty;
import org.saintandreas.serket.didl.types.Item;

public interface ImageItem extends Item {
    @DIDLProperty(value="longDescription", namespace=DIDLNamespace.UPNP)
    public String getLongDescription();

//    @DIDLProperty(value="rating", namespace=DIDLNamespace.UPNP)
//    @DIDLProperty(value="actor", namespace=DIDLNamespace.UPNP)
//    @DIDLProperty(value="director", namespace=DIDLNamespace.UPNP)

    @DIDLProperty(value="description", namespace=DIDLNamespace.DUBLIN)
    public String getDescription();

    @DIDLProperty(value="publisher", namespace=DIDLNamespace.DUBLIN)
    public String getPublisher();

    @DIDLProperty(value="date", namespace=DIDLNamespace.DUBLIN)
    public Date getDate();

    @DIDLProperty(value="rights", namespace=DIDLNamespace.DUBLIN)
    public String getRights();


}
