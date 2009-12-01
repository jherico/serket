package org.saintandreas.serket.didl;

public interface Desc {

    @DIDLAttribute(value="id", required=true)
    public String getId();

    @DIDLAttribute("type") 
    public String getType();

    @DIDLAttribute("nameSpace") 
    public String getNameSpace();
}
