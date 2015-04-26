package com.mredrock.cyxbs.presenter.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.impl.DiscoveryContainerVu;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryContainerFragment extends BasePresenterFragment<DiscoveryContainerVu> {


    public DiscoveryContainerFragment() {
        // Required empty public constructor
    }

    @Override
    public Class<DiscoveryContainerVu> getVuClass() {
        return DiscoveryContainerVu.class;
    }

    @Override
    public void onBindVu() {

    }

    public static DiscoveryContainerFragment newInstance() {
        return new DiscoveryContainerFragment();
    }
}
