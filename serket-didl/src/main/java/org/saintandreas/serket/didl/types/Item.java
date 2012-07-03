package org.saintandreas.serket.didl.types;

import org.saintandreas.serket.didl.DIDLNamespace;
import org.saintandreas.serket.didl.annotations.DIDLAttribute;
import org.saintandreas.serket.didl.annotations.DIDLElement;
import org.saintandreas.serket.didl.annotations.DIDLProperty;

@DIDLElement("item")
public interface Item extends Object {
    @DIDLAttribute(value="parentID", required=true)
    public String getParentID();

    @DIDLAttribute(value="restricted", required=true)
    public boolean isRestricted();

    @DIDLAttribute("neverPlayable")
    public Boolean isNeverPlayable();

    @DIDLProperty(value="title", namespace=DIDLNamespace.DUBLIN, required=true, order=0)
    public String getTitle();

    @DIDLProperty(value="class", namespace=DIDLNamespace.UPNP, required=true, order=1)
    public String getUpnpClass();
    
    @DIDLElement(value="res")
    public Resource getRes();
    
    

}
