package org.saintandreas.serket.didl.types.audio;

import org.saintandreas.serket.didl.DIDLNamespace;
import org.saintandreas.serket.didl.annotations.DIDLProperty;
import org.saintandreas.serket.didl.types.Item;

public interface AudioItem extends Item {
    @DIDLProperty(value="genre", namespace=DIDLNamespace.UPNP)
    public String getGenre();

    @DIDLProperty(value="description", namespace=DIDLNamespace.DUBLIN)
    public String getDescription();

    @DIDLProperty(value="longDescription", namespace=DIDLNamespace.UPNP)
    public String getLongDescription();

    @DIDLProperty(value="publisher", namespace=DIDLNamespace.DUBLIN)
    public String getPublisher();

    @DIDLProperty(value="language", namespace=DIDLNamespace.DUBLIN)
    public String getLanguage();

    @DIDLProperty(value="relation", namespace=DIDLNamespace.DUBLIN)
    public String getRelation();

    @DIDLProperty(value="rights", namespace=DIDLNamespace.DUBLIN)
    public String getRights();
}
