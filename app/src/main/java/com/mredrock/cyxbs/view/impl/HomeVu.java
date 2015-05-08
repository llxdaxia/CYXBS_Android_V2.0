package com.mredrock.cyxbs.view.impl;

import android.content.res.Configuration;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
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

    /**
     * 配置抽屉
     *
     * @param activity Activity对象
     */
    public void configureDrawer(final AppCompatActivity activity) {

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
        mDrawerLayout.setStatusBarBackground(R.color.theme_primary_dark);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mDrawerLayout.post(mDrawerToggle::syncState);
    }

    public void closeDrawer() {
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    public boolean onDrawerToggleSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}
