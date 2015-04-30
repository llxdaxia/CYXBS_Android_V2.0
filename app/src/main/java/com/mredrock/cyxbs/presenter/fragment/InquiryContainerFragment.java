package com.mredrock.cyxbs.presenter.fragment;


import com.mredrock.cyxbs.view.impl.InquiryContainerVu;

/**
 * 各种成绩查询界面的Fragment容器
 */
public class InquiryContainerFragment extends BasePresenterFragment<InquiryContainerVu> {

    public InquiryContainerFragment() {
        // Required empty public constructor
    }

    @Override
    public Class<InquiryContainerVu> getVuClass() {
        return InquiryContainerVu.class;
    }

    @Override
    public void onBindVu() {
    }

    public static InquiryContainerFragment newInstance(){
        return new InquiryContainerFragment();
    }
}
