package com.mredrock.cyxbs.presenter.activity;

import com.mredrock.cyxbs.view.impl.MainVu;


public class MainActivity extends BasePresenterActivity<MainVu> {


    @Override
    protected Class<MainVu> getVuClass() {
        return MainVu.class;
    }

    @Override
    protected boolean shouldSwipeBack() {
        return false;
    }

}
