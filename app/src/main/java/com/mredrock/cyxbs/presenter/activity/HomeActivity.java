package com.mredrock.cyxbs.presenter.activity;

import android.content.res.Configuration;
import android.view.MenuItem;

import com.mredrock.cyxbs.presenter.fragment.ScheduleContainerFragment;
import com.mredrock.cyxbs.view.impl.HomeVu;


public class HomeActivity extends BasePresenterActivity<HomeVu> {
    @Override
    protected boolean shouldSwipeBack() {
        return false;
    }

    @Override
    public Class<HomeVu> getVuClass() {
        return HomeVu.class;
    }

    @Override
    public void onBindVu() {
        fm.beginTransaction()
                .replace(vu.getContainerId(), ScheduleContainerFragment.newInstance())
                .commit();
        vu.configureDrawer(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        vu.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return vu.onDrawerToggleSelected(item) || super.onOptionsItemSelected(item);
    }
}
