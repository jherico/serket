package org.saintandreas.serket.impl.didl.event;

import java.util.EventObject;

import org.saintandreas.serket.impl.didl.SerketBase;

@SuppressWarnings("serial")
public class SerketEvent extends EventObject {

    public enum EventType {
        OBJECT_ADDED, OBJECT_REMOVED, OBJECT_CHANGED, CONTAINER_CHANGED
    }
    
    public final EventType type;

    public SerketEvent(SerketBase source, EventType type) {
        super(source);
        this.type = type;
        
    }
    
    public SerketBase getSerketBase() {
        return (SerketBase)getSource();
    }

}
