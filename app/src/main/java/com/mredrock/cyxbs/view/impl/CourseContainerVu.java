package com.mredrock.cyxbs.view.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.IVu;

/**
 * Created by david on 4/15/15.
 * email: yangcheng0816@gmail.com
 */
public class CourseContainerVu extends AbsFragmentVu {
    View view;

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_schedule_container, container, false);
    }

    @Override
    public View getView() {
        return view;
    }
}
