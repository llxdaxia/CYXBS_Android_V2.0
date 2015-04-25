package com.mredrock.cyxbs.presenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mredrock.cyxbs.view.IVu;

/**
 * Created by David on 15/4/24.
 */
public abstract class BasePresenterAdapter<V extends IVu> extends BaseAdapter {
    protected V vu;

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            try {
                vu = getVuClass().newInstance();
                vu.init(inflater, parent);
                convertView = vu.getView();
                convertView.setTag(vu);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            vu = (V) convertView.getTag();
        }
        if (convertView != null) {
            onBindListItemVu(position);
        }
        return convertView;
    }

    protected abstract void onBindListItemVu(int position);

    protected abstract Class<V> getVuClass();
}
