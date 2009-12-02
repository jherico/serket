package org.saintandreas.serket.impl.didl;

import org.saintandreas.serket.didl.DIDLObject;
import org.saintandreas.serket.impl.didl.event.SerketEventGenerator;

public interface SerketBase extends SerketEventGenerator, DIDLObject{
    public SerketContainer<?> getParent();
    public String getLocalId();
}
