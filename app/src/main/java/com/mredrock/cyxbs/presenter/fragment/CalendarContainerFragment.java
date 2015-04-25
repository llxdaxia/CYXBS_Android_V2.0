package com.mredrock.cyxbs.presenter.fragment;


import com.mredrock.cyxbs.view.impl.CalendarContainerVu;

/**
 */
public class CalendarContainerFragment extends BasePresenterFragment<CalendarContainerVu> {


    public CalendarContainerFragment() {
        // Required empty public constructor
    }

    @Override
    public Class<CalendarContainerVu> getVuClass() {
        return CalendarContainerVu.class;
    }

    @Override
    public void onBindVu() {

    }

    public static CalendarContainerFragment newInstance() {
        return new CalendarContainerFragment();
    }
}
