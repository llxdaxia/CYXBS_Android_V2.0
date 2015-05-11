package com.mredrock.cyxbs.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mredrock.cyxbs.view.IVu;
import com.mredrock.cyxbs.view.RecyclerVuHolder;

import java.util.ArrayList;

/**
 * TODO 抽象了的RecyclerView的适配器，还没写好。。。
 * Created by David on 15/4/27.
 */
public abstract class RecyclerPresenterAdapter<T,V extends IVu> extends RecyclerView.Adapter<RecyclerVuHolder> {
    private V vu;
    private ArrayList<T> datas = new ArrayList<>();

    @Override
    public RecyclerVuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        try {
            vu = getVuClass().newInstance();
            vu.init(inflater, parent);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return vu == null ? null : new RecyclerVuHolder(vu.getView());
    }

    @Override
    public final void onBindViewHolder(RecyclerVuHolder holder, int position) {
        onBindItemVu();
    }

    protected abstract void onBindItemVu();

    protected abstract Class<V> getVuClass();
}
