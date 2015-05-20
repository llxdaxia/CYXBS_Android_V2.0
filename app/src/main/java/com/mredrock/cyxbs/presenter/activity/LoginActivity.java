package com.mredrock.cyxbs.presenter.activity;

import android.content.Intent;

import com.mredrock.cyxbs.UIThread;
import com.mredrock.cyxbs.model.UserModel;
import com.mredrock.cyxbs.model.mapper.UserEntityDataMapper;
import com.mredrock.cyxbs.model.mapper.UserModelDataMapper;
import com.mredrock.cyxbs.model.repository.UserDataRepository;
import com.mredrock.cyxbs.model.repository.datasource.DataStoreFactory;
import com.mredrock.cyxbs.domain.interactor.GetUserUseCase;
import com.mredrock.cyxbs.domain.model.User;
import com.mredrock.cyxbs.presenter.ISubcriber;
import com.mredrock.cyxbs.presenter.SubscriberProxy;
import com.mredrock.cyxbs.view.impl.LoginVu;
import com.seancode.common.utils.ScreenUtils;

import static com.seancode.common.utils.LogUtils.*;

public class LoginActivity extends BasePresenterActivity<LoginVu> implements ISubcriber<User> {

    SubscriberProxy<User> userModelSubscriberProxy;

    GetUserUseCase getUserUserCase;
    UserModelDataMapper userModelDataMapper;

    @Override
    protected boolean shouldSwipeBack() {
        return false;
    }

    @Override
    public Class<LoginVu> getVuClass() {
        return LoginVu.class;
    }

    @Override
    public void onBindVu() {
        vu.setLoginCallback(result -> attemptLogin());
    }

    private void attemptLogin() {
        getUserDetails(vu.getStuEdit().getText().toString(), vu.getIdEdit().getText().toString());
    }

    private void getUserDetails(String stuNum, String idNum) {
        userModelSubscriberProxy = new SubscriberProxy<>(this);

        getUserUserCase = new GetUserUseCase(
                new UIThread(),
                idNum,
                new UserDataRepository(
                        new DataStoreFactory(this)
                        , new UserEntityDataMapper())
                , stuNum);
        this.getUserUserCase.execute(userModelSubscriberProxy);
    }

    @Override
    public void onCompleted() {
        LOGD("[onCompleted]", "onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        LOGE("[onError]", e.getMessage());
        ScreenUtils.Toaster.showLong(this, e.getMessage());
    }

    @Override
    public void onNext(User user) {
        userModelDataMapper = new UserModelDataMapper();
        UserModel userModel = userModelDataMapper.transform(user);
        vu.showOk(userModel);
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        this.finish();
    }

}
