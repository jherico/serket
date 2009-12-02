package org.saintandreas.serket.didl;

import org.saintandreas.serket.didl.annotations.DIDLAttribute;
import org.saintandreas.serket.didl.annotations.DIDLElement;

@DIDLElement("desc")
public interface DIDLDesc extends DIDLObject{

    @DIDLAttribute("type") 
    public String getType();

    @DIDLAttribute("nameSpace") 
    public String getNameSpace();
}
