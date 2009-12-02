package org.saintandreas.serket.impl.didl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.saintandreas.serket.didl.DIDLContainer;
import org.saintandreas.serket.impl.didl.event.SerketEvent;
import org.saintandreas.serket.impl.didl.event.SerketEventListener;

public abstract class AContainerImpl<T extends SerketBase> extends BaseImpl implements SerketContainer<T>{

    private List<T> children = new ArrayList<T>();
    private boolean increment = false;
    private int updateId = 1;

    public AContainerImpl(SerketContainer<?> parent) {
        super(parent);
    }

    @Override
    public String getUpnpClass() {
        return DIDLContainer.UPNP_OBJECT_CLASS;
    }

    @Override
    public Boolean isNeverPlayable() {
        return null;
    }

    @Override
    public Boolean isSearchable() {
        return null;
    }

    @Override
    public boolean isRestricted() {
        return true;
    }
    
    @Override
    public void onEvent(SerketEvent event) {
        getParent().onEvent(event);
    }

    @Override
    public Integer getChildCount() {
        refreshChildren();
        return children.size();
    }

    @Override
    public void addChild(T child) {
        children.add(child);
        if (child instanceof SerketContainer<?>) {
            ((SerketContainer<?>)child).addListener(this);
        }
        sendEvent(new SerketEvent(child, SerketEvent.EventType.OBJECT_ADDED));
    }

    @Override
    public void removeChild(T child) {
        children.remove(child);
        if (child instanceof SerketContainer<?>) {
            ((SerketContainer<?>)child).removeListener(this);
        }
        sendEvent(new SerketEvent(child, SerketEvent.EventType.OBJECT_REMOVED));
    }

    @Override
    public List<T> getChildren(int start, int count) {
        return Collections.unmodifiableList(children.subList(start, Math.min(children.size(), start + count)));
    }
    
    protected List<T> getChildren() {
        return Collections.unmodifiableList(children);
    }
    
    public void clearChildren() {
        List<T> oldChildren = new ArrayList<T>(getChildren());
        for (T child : oldChildren) {
            removeChild(child);
        }
    }

    protected void increment() {
        increment = true;
    }
    
    public int getUpdateId() {
        if (increment) {
            ++updateId;
            increment = false;
        }
        return updateId;
    }
}
