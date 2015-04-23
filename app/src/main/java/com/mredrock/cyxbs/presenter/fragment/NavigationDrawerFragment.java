package com.mredrock.cyxbs.presenter.fragment;


import android.app.Fragment;
import android.os.Bundle;

import com.mredrock.cyxbs.view.impl.NavVu;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends BasePresenterFragment<NavVu> {

    private boolean mFromSavedInstanceState;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//Necessary for clicking to open the drawer!!!
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }
    }


    @Override
    public Class<NavVu> getVuClass() {
        return NavVu.class;
    }

    @Override
    public void onBindVu() {

    }

}
