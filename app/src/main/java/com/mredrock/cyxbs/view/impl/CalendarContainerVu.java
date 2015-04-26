package com.mredrock.cyxbs.view.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.R;

/**
 * Created by David on 15/4/25.
 */
public class CalendarContainerVu extends AbsFragmentVu {
    View view;

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_calendar_container, container, false);
    }

    @Override
    public View getView() {
        return view;
    }
}
