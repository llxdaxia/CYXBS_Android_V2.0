package com.mredrock.cyxbs.presenter.fragment;


import com.mredrock.cyxbs.view.impl.ScheduleContainerVu;

/**
 */
public class ScheduleContainerFragment extends BasePresenterFragment<ScheduleContainerVu> {


    public ScheduleContainerFragment() {
        // Required empty public constructor
    }

    @Override
    public Class<ScheduleContainerVu> getVuClass() {
        return ScheduleContainerVu.class;
    }

    @Override
    public void onBindVu() {

    }

    public static ScheduleContainerFragment newInstance(){
        return new ScheduleContainerFragment();
    }
}
