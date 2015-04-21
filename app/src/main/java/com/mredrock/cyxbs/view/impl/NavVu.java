package com.mredrock.cyxbs.view.impl;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.IVu;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by david on 4/13/15.
 * email: yangcheng0816@gmail.com
 */
public class NavVu implements IVu {

    private View view;
    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.inject(this,view);
    }

    @Override
    public View getView() {
        return view;
    }

}
