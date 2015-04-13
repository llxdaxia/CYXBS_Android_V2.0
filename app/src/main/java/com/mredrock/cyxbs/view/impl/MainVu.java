package com.mredrock.cyxbs.view.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.Vu;

/**
 * Created by david on 4/13/15.
 * email: yangcheng0816@gmail.com
 */
public class MainVu implements Vu {
    private View view;
    private FrameLayout containerView;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.activity_main, container, false);
//        containerView = (FrameLayout) view.findViewById(R.id.container);
    }

    @Override
    public View getView() {
        return view;
    }
}
