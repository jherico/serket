package org.saintandreas.serket.impl.didl.event;

public interface SerketEventGenerator {
    public void addListener(SerketEventListener listener);
    public void removeListener(SerketEventListener listener);
    public void sendEvent(SerketEvent serketEvent);

}
