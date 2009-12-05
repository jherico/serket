package org.saintandreas.serket.impl.didl.event;

import java.util.EventListener;

public interface SerketEventListener extends EventListener {
    public void onEvent(SerketEvent event);
}
