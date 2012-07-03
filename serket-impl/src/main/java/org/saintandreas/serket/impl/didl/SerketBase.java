package org.saintandreas.serket.impl.didl;

import org.saintandreas.serket.didl.types.Object;
import org.saintandreas.serket.impl.didl.event.SerketEventGenerator;

public interface SerketBase extends SerketEventGenerator, Object{
    public SerketContainer<?> getParent();
    public String getLocalId();
}
