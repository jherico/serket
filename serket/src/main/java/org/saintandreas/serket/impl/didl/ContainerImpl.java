package org.saintandreas.serket.impl.didl;

import java.util.ArrayList;
import java.util.List;

public abstract class ContainerImpl extends BaseImpl implements org.saintandreas.serket.didl.Container {

    public ContainerImpl(ContainerImpl parent) {
        super(parent);
    }

    protected List<BaseImpl> children = new ArrayList<BaseImpl>();

    public List<BaseImpl> getRawChildren() {
        refreshChildren();
        return children;
    }

    protected abstract void refreshChildren();
//    protected abstract void onChildChanged(String idChanged);
}
