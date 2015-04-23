package com.mredrock.cyxbs.view.impl;

import android.content.res.Configuration;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.mredrock.cyxbs.R;

import butterknife.InjectView;

/**
 * Created by david on 4/13/15.
 * email: yangcheng0816@gmail.com
 */
public class HomeVu extends AbsActivityVu {
    private ActionBarDrawerToggle mDrawerToggle;

    @InjectView(R.id.container)
    FrameLayout containerView;

    @InjectView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean shouldToolbarShow() {
        return true;
    }

    @Override
    public boolean shouldArrowShow() {
        return true;
    }

    public int getContainerId() {
        return containerView.getId();
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    public void configureDrawer(final ActionBarActivity activity) {
        mDrawerToggle = new ActionBarDrawerToggle(activity, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                activity.supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                activity.supportInvalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    public boolean onDrawerToggleSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return false;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        mDrawerToggle.onConfigurationChanged(newConfig);

    }

}
