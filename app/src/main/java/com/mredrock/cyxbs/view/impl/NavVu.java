package com.mredrock.cyxbs.view.impl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.presenter.adapter.NavigationDrawerAdapter;
import com.mredrock.cyxbs.view.IVuCallback;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

/**
 * Created by david on 4/13/15.
 * email: yangcheng0816@gmail.com
 */
public class NavVu extends AbsFragmentVu {

    private View                 view;
    private IVuCallback<Integer> selectCallback;

    @InjectView(R.id.drawer_all)
    ListView mListView;

    @OnItemClick(R.id.drawer_all)
    public void execute(int position) {
        if (selectCallback != null) {
            selectCallback.execute(position - 1);
        }
    }

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.inject(this, view);
        View headerView = inflater.inflate(R.layout.navigation_drawer_header, mListView, false);
        mListView.addHeaderView(headerView, null, false);
    }

    @Override
    public View getView() {
        return view;
    }

    public void setSelectCallback(IVuCallback<Integer> callback) {
        this.selectCallback = callback;
    }

    public void setListAdapter(NavigationDrawerAdapter adapter) {
        mListView.setAdapter(adapter);
    }
}
