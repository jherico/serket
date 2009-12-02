package org.saintandreas.serket.didl;

import org.saintandreas.serket.didl.annotations.DIDLAttribute;
import org.saintandreas.serket.didl.annotations.DIDLElement;
import org.saintandreas.serket.didl.annotations.DIDLSubElement;

@DIDLElement("item")
public interface DIDLItem extends DIDLObject {
    @DIDLAttribute(value="parentID", required=true)
    public String getParentID();

    @DIDLAttribute(value="restricted", required=true)
    public boolean isRestricted();

    @DIDLAttribute("neverPlayable")
    public Boolean isNeverPlayable();

    @DIDLSubElement(value="title", namespace=DIDLNamespace.DUBLIN, required=true, order=0)
    public String getTitle();

    @DIDLSubElement(value="class", namespace=DIDLNamespace.UPNP, required=true, order=1)
    public String getUpnpClass();

}
