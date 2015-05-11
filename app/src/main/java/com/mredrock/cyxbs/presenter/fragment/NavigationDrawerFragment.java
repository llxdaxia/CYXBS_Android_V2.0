package com.mredrock.cyxbs.presenter.fragment;


import android.os.Bundle;

import com.mredrock.cyxbs.model.event.NavEvent;
import com.mredrock.cyxbs.presenter.adapter.NavigationDrawerAdapter;
import com.mredrock.cyxbs.view.IVuCallback;
import com.mredrock.cyxbs.view.impl.NavVu;

import java.util.ArrayList;


/**
 * 抽屉的fragment
 */
public class NavigationDrawerFragment extends BasePresenterFragment<NavVu> {
    NavigationDrawerAdapter adapter;
    ArrayList<String> items = new ArrayList<>();

    IVuCallback<Integer> mCallback = result -> bus.postSticky(new NavEvent(result));

    public NavigationDrawerFragment() {
        items.add("课表");
        items.add("安排");
        items.add("资讯");
        items.add("查询");
        items.add("发现");
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
        adapter = new NavigationDrawerAdapter(getActivity(), items);
        vu.setListAdapter(adapter);
        vu.setSelectCallback(mCallback);
    }

}
