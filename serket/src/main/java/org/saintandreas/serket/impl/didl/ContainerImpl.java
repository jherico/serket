package org.saintandreas.serket.impl.didl;

import java.util.ArrayList;
import java.util.List;

import org.saintandreas.serket.didl.Base;
import org.saintandreas.serket.didl.Container;
import org.saintandreas.serket.didl.DIDLItem;

@DIDLItem("container")
public abstract class ContainerImpl<T extends Base> extends BaseImpl implements Container {

    public ContainerImpl(Container parent) {
        super(parent);
    }

    protected List<T> children = new ArrayList<T>();

    public List<T> getRawChildren() {
        return children;
    }

    protected abstract boolean refreshChildren();

    @Override
    public Integer getChildCount() {
        refreshChildren();
        return getRawChildren().size();
    }

    @Override
    public Boolean isSearchable() {
        return null;
    }

    @Override
    public Boolean isNeverPlayable() {
        return null;
    }

    @Override
    public boolean isRestricted() {
        return true;
    }


}
