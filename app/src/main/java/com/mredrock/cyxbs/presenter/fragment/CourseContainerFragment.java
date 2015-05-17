package com.mredrock.cyxbs.presenter.fragment;


import com.mredrock.cyxbs.view.impl.CourseContainerVu;

/**
 * 放课表的Fragment容器
 */
public class CourseContainerFragment extends BasePresenterFragment<CourseContainerVu> {

    public CourseContainerFragment() {
        // Required empty public constructor
    }

    @Override
    public Class<CourseContainerVu> getVuClass() {
        return CourseContainerVu.class;
    }

    @Override
    public void onBindVu() {

    }

    public static CourseContainerFragment newInstance(){
        return new CourseContainerFragment();
    }
}
