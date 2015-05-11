package com.mredrock.cyxbs.presenter.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.impl.NavItemVuHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * P层的抽屉的适配器
 * Created by David on 15/4/25.
 */
public class NavigationDrawerAdapter extends BasePresenterAdapter<String,NavItemVuHolder> {

    public NavigationDrawerAdapter(Context mContext, ArrayList<String> datas) {
        super(mContext, datas);
    }

    @Override
    protected void onBindListItemVu(int position, View convertView, ViewGroup parent) {
        TextView textView = vu.getView(R.id.item_nav);
        textView.setText(getItem(position));
        //以后应该会在VuHolder里面将方法抽象好，然后直接传id河数据对象就ok
    }

    @Override
    protected Class<NavItemVuHolder> getVuClass() {
        return NavItemVuHolder.class;
    }

}
