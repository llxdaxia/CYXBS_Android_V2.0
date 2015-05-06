package com.mredrock.cyxbs.presenter.activity;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MenuItem;

import com.mredrock.cyxbs.model.event.NavEvent;
import com.mredrock.cyxbs.presenter.fragment.CalendarContainerFragment;
import com.mredrock.cyxbs.presenter.fragment.DiscoveryContainerFragment;
import com.mredrock.cyxbs.presenter.fragment.InquiryContainerFragment;
import com.mredrock.cyxbs.presenter.fragment.NewsContainerFragment;
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
        navigate(0);
        vu.configureDrawer(this);
    }

    @Override
    protected void afterResume() {
        bus.registerSticky(this);
    }

    @Override
    protected void beforePause() {
        bus.unregister(this);
    }

    @Override
    public boolean handleBackPressed() {
        bus.removeAllStickyEvents();
        if(vu.isDrawerOpen()){
            vu.closeDrawer();
            return true;
        }
        return false;
    }

    public void onEvent(NavEvent event) {
        navigate(event.position);
    }

    private void navigate(int position) {
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = ScheduleContainerFragment.newInstance();
                break;
            case 1:
                fragment = CalendarContainerFragment.newInstance();
                break;
            case 2:
                fragment = NewsContainerFragment.newInstance();
                break;
            case 3:
                fragment = InquiryContainerFragment.newInstance();
                break;
            case 4:
                fragment = DiscoveryContainerFragment.newInstance();
                break;
            default:
                fragment = ScheduleContainerFragment.newInstance();
                break;
        }
        transaction.replace(vu.getContainerId(),fragment ).commit();
        vu.closeDrawer();
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
