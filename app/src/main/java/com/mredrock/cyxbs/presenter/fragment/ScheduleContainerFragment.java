package com.mredrock.cyxbs.presenter.fragment;


import com.mredrock.cyxbs.view.impl.ScheduleContainerVu;

/**
 */
public class ScheduleContainerFragment extends BasePresenterFragment<ScheduleContainerVu> {


    public ScheduleContainerFragment() {
        // Required empty public constructor
    }


    @Override
    protected Class<ScheduleContainerVu> getVuClass() {
        return ScheduleContainerVu.class;
    }

    public static ScheduleContainerFragment newInstance(){
        return new ScheduleContainerFragment();
    }
}
