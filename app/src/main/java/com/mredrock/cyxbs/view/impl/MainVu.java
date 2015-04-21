package com.mredrock.cyxbs.view.impl;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.presenter.fragment.NavigationDrawerFragment;
import com.mredrock.cyxbs.view.IVu;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by david on 4/13/15.
 * email: yangcheng0816@gmail.com
 */
public class MainVu implements IVu {
    private View view;
    private NavigationDrawerFragment mNavDrawerFragment;

    @InjectView(R.id.home_toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.container)
    FrameLayout containerView;

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.activity_home, container, false);
        ButterKnife.inject(this, view);

    }

    @Override
    public View getView() {
        return view;
    }

    public DrawerLayout getDrawerLayout() {
        return mDrawerLayout;
    }


    public Toolbar getToolbar() {
        return mToolbar;
    }

    public int getContainerId() {
        return containerView.getId();
    }

}
