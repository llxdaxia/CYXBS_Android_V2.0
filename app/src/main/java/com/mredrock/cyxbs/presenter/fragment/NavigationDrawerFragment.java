package com.mredrock.cyxbs.presenter.fragment;


import android.app.Fragment;
import android.os.Bundle;

import com.mredrock.cyxbs.model.event.NavEvent;
import com.mredrock.cyxbs.presenter.adapter.NavigationDrawerAdapter;
import com.mredrock.cyxbs.view.IVuCallback;
import com.mredrock.cyxbs.view.impl.NavVu;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends BasePresenterFragment<NavVu> {
    NavigationDrawerAdapter adapter = new NavigationDrawerAdapter();
    IVuCallback<Integer> mCallback = new IVuCallback<Integer>() {
        @Override
        public void execute(Integer result) {
            bus.postSticky(new NavEvent(result));
        }
    };

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Class<NavVu> getVuClass() {
        return NavVu.class;
    }

    @Override
    public void onBindVu() {
        vu.setListAdapter(adapter);
        vu.setSelectCallback(mCallback);
    }

}
