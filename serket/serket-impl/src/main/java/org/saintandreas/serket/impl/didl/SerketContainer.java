package org.saintandreas.serket.impl.didl;

import java.util.List;

import org.saintandreas.serket.didl.types.Container;
import org.saintandreas.serket.impl.didl.event.SerketEvent;
import org.saintandreas.serket.impl.didl.event.SerketEventListener;

public interface SerketContainer<T extends SerketBase> extends SerketEventListener, SerketBase, Container{
    // TODO this kind of getChildren is incompatible with sort criteria
    public List<T> getChildren(int start, int count);
    public int getUpdateId(); 

    public void addListener(SerketEventListener listener);
    public void removeListener(SerketEventListener listener);

    public void addChild(T child);
    public void removeChild(T child);

    public void clearChildren();
    public boolean refreshChildren();

}
