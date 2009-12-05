package org.saintandreas.serket.didl.types;

import org.saintandreas.serket.didl.annotations.DIDLAttribute;
import org.saintandreas.serket.didl.annotations.DIDLElement;

@DIDLElement("desc")
public interface Desc extends Object{

    @DIDLAttribute("type") 
    public String getType();

    @DIDLAttribute("nameSpace") 
    public String getNameSpace();
}
