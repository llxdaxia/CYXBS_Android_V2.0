package com.mredrock.cyxbs.view.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mredrock.cyxbs.view.IVu;

/**
 * Created by David on 15/4/23.
 */
public abstract class AbsFragmentVu implements IVu{
    private Context context;
    @Override
    public final void init(LayoutInflater inflater, ViewGroup container) {
        context = inflater.getContext();
        onCreateView(inflater, container);
    }

    public abstract void onCreateView(LayoutInflater inflater, ViewGroup container);

    public final Context getContext() {
        return context;
    }
}
