package com.mredrock.cyxbs.view.impl;

import android.widget.Toast;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.data.model.UserModel;

/**
 * Created by David on 15/5/17.
 */
public class LoginVu extends AbsActivityVu {
    @Override
    public void onCreate() {
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean shouldToolbarShow() {
        return false;
    }

    @Override
    public boolean shouldArrowShow() {
        return false;
    }

    public void showOk(UserModel model) {
        Toast.makeText(getContext(), "~~" + model.getName(), Toast.LENGTH_LONG).show();
    }
}
