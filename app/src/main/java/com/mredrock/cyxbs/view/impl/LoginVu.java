package com.mredrock.cyxbs.view.impl;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.model.UserModel;
import com.mredrock.cyxbs.view.IVuCallback;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by David on 15/5/17.
 */
public class LoginVu extends AbsActivityVu {
    IVuCallback loginCallback;

    @InjectView(R.id.edit_stu_num)
    EditText mEditTextStu;

    @InjectView(R.id.edit_id_num)
    EditText mEditTextId;

    @InjectView(R.id.btn_login)
    Button mButtonLogin;

    @SuppressWarnings("unchecked")
    @OnClick(R.id.btn_login)
    public void executeLogin() {
        if (loginCallback != null) {
            loginCallback.execute(null);
        }
    }

    @Override
    public void onCreate() {
        setContentView(R.layout.activity_login);
    }

    public EditText getStuEdit() {
        return mEditTextStu;
    }

    public EditText getIdEdit() {
        return mEditTextId;
    }

    public void setLoginCallback(IVuCallback loginCallback) {
        this.loginCallback = loginCallback;
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
