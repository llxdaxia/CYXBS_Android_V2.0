package com.mredrock.cyxbs.view.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.R;

import butterknife.ButterKnife;

/**
 * Created by david on 4/13/15.
 * email: yangcheng0816@gmail.com
 */
public class NavVu extends AbsFragmentVu {

    private View view;

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.inject(this,view);
    }

    @Override
    public View getView() {
        return view;
    }
}
