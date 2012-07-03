package org.saintandreas.serket.impl.didl;

import org.saintandreas.serket.didl.types.Item;

public abstract class ItemImpl extends BaseImpl implements Item {

    public ItemImpl(SerketContainer<?> parent) {
        super(parent);
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
