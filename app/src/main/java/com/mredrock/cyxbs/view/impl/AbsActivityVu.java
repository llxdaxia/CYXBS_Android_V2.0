package com.mredrock.cyxbs.view.impl;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.IVu;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by David on 15/4/23.
 */
public abstract class AbsActivityVu implements IVu {
    private View           mView;
    private Context        context;
    private LayoutInflater mLayoutInflater;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public final void init(LayoutInflater inflater, ViewGroup container) {
        context = inflater.getContext();
        mLayoutInflater = inflater;
        onCreate();
    }

    public abstract void onCreate();

    public void setContentView(View view) {
        mView = view;
        ButterKnife.inject(this, mView);
        configureToolbar();
    }

    public void setContentView(@LayoutRes int layoutResID) {
        mView = mLayoutInflater.inflate(layoutResID, null);
        ButterKnife.inject(this, mView);
        configureToolbar();
    }

    public void configureToolbar() {
        ActionBarActivity activity = (ActionBarActivity) context;
        if (mToolbar != null && shouldToolbarShow()) {
            activity.setSupportActionBar(mToolbar);
            if (shouldArrowShow()) {
                activity.getSupportActionBar().setHomeButtonEnabled(true);
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    /**
     * 如果xml里面没有toolbar的话这里一定要返回false
     * @return 是否要显示Toolbar
     */
    public abstract boolean shouldToolbarShow();

    /**
     * Toolbar的箭头要不要显示呀
     * @return 是否显示箭头
     */
    public abstract boolean shouldArrowShow();

    /**
     *设置显示标题的内容
     * @param title 标题内容
     */
    public void setLabel(CharSequence title) {
        if (mToolbar != null) {
            mToolbar.setTitle(title);
        }
    }

    /**
     * 设置显示标题的内容
     * @param stringResID 标题内容的资源id
     */
    public void setLabel(@StringRes int stringResID) {
        if (mToolbar != null) {
            mToolbar.setTitle(stringResID);
        }
    }

    public final Context getContext() {
        return context;
    }

    @Override
    public View getView() {
        return mView;
    }
}
