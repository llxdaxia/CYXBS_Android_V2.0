package com.mredrock.cyxbs.view.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.IVu;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by David on 15/4/25.
 */
public class NavItemVu implements IVu {
    View view;
    @InjectView(R.id.item_nav)
    TextView itemText;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.item_navigation_drawer, container, false);
        ButterKnife.inject(this, view);
    }

    @Override
    public View getView() {
        return view;
    }

    public void setItemText(String s) {
        itemText.setText(s);
    }
}
