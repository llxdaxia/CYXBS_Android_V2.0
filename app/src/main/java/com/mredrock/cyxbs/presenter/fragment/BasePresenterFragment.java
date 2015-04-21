package com.mredrock.cyxbs.presenter.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.cyxbs.view.IVu;

import de.greenrobot.event.EventBus;

/**
 * Created by david on 4/13/15.
 * email: yangcheng0816@gmail.com
 */
public abstract class BasePresenterFragment<V extends IVu> extends Fragment {

    protected V vu;
    protected EventBus bus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = EventBus.getDefault();
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = null;
        try {
            vu = getVuClass().newInstance();
            vu.init(inflater, container);
            view = vu.getView();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onBindVu();
    }

    @Override
    public final void onDestroyView() {
        onDestroyVu();
        vu = null;
        super.onDestroyView();
    }

    protected void onDestroyVu() {
    }

    @Override
    public final void onPause() {
        beforePause();
        super.onPause();
    }

    protected void beforePause() {
    }

    @Override
    public final void onResume() {
        super.onResume();
        afterResume();
    }

    protected void afterResume() {
    }

    protected void onBindVu() {
    }

    protected abstract Class<V> getVuClass();

}
