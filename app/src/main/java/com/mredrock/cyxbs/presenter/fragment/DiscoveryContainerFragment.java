package com.mredrock.cyxbs.presenter.fragment;


import com.mredrock.cyxbs.view.impl.DiscoveryContainerVu;


/**
 * 发现界面容器Fragment
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
