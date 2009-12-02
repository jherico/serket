package org.saintandreas.serket.impl.didl;

import org.saintandreas.serket.didl.DIDLItem;

public abstract class ItemImpl extends BaseImpl implements DIDLItem {

    public ItemImpl(SerketContainer<?> parent) {
        super(parent);
    }

    @Override
    public String getLocalId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTitle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getUpnpClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean isNeverPlayable() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isRestricted() {
        // TODO Auto-generated method stub
        return false;
    }

}
