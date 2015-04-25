package com.mredrock.cyxbs.presenter.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.impl.NewsContainerVu;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsContainerFragment extends BasePresenterFragment<NewsContainerVu> {

    public NewsContainerFragment() {
    }

    @Override
    public Class<NewsContainerVu> getVuClass() {
        return NewsContainerVu.class;
    }

    @Override
    public void onBindVu() {

    }

    public static NewsContainerFragment newInstance(){
        return new NewsContainerFragment();
    }
}
