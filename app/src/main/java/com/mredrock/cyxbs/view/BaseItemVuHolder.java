package com.mredrock.cyxbs.view;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by David on 15/4/29.
 */
public abstract class BaseItemVuHolder implements IVu {
    private final SparseArray<View> views;
    private int position;
    private View mConvertView;
    //Package private field to retain the associated user object and detect a change
    private Object associatedObject;

    public BaseItemVuHolder() {
        this.views = new SparseArray<>();
    }

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        init(inflater, container, -1);
    }

    public void init(LayoutInflater inflater, ViewGroup container, int position) {
        this.position = position;
        mConvertView = inflater.inflate(getItemLayoutId(), container, false);
        mConvertView.setTag(this);
    }

    public <T extends View> T getView(int viewId) {
        return retrieveView(viewId);
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * Retrieve the overall position of the data in the list.
     * @throws IllegalArgumentException If the position hasn't been set at the construction of the this helper.
     */
    public int getPosition() {
        if (position == -1)
            throw new IllegalStateException("Use BaseItemVuHolder.init() " +
                    "with position if you need to retrieve the position.");
        return position;
    }

    /** Retrieves the last converted object on this view. */
    public Object getAssociatedObject() {
        return associatedObject;
    }

    /** Should be called during convert */
    public void setAssociatedObject(Object associatedObject) {
        this.associatedObject = associatedObject;
    }

    protected abstract int getItemLayoutId();

    @Override
    public View getView() {
        return mConvertView;
    }
}
