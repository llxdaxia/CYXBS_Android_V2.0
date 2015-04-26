package com.mredrock.cyxbs.presenter.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.impl.InquiryContainerVu;

/**
 * A simple {@link Fragment} subclass.
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
