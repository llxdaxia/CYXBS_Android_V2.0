package com.mredrock.cyxbs.presenter.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.mredrock.cyxbs.UIThread;
import com.mredrock.cyxbs.data.mapper.UserEntityDataMapper;
import com.mredrock.cyxbs.data.mapper.UserModelDataMapper;
import com.mredrock.cyxbs.data.model.UserModel;
import com.mredrock.cyxbs.data.repository.UserDataRepository;
import com.mredrock.cyxbs.data.repository.datasource.DataStoreFactory;
import com.mredrock.cyxbs.di.component.DaggerUserComponent;
import com.mredrock.cyxbs.di.component.UserComponent;
import com.mredrock.cyxbs.di.modules.UserModule;
import com.mredrock.cyxbs.domain.interactor.GetUserUseCase;
import com.mredrock.cyxbs.domain.model.User;
import com.mredrock.cyxbs.presenter.ISubcriber;
import com.mredrock.cyxbs.presenter.SubscriberProxy;
import com.mredrock.cyxbs.view.impl.LoginVu;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class LoginActivity extends BasePresenterActivity<LoginVu> implements ISubcriber<User> {

    private UserComponent userComponent;
    SubscriberProxy<User> userModelSubscriberProxy;

    //    @Inject
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
        getUserDetails();
    }

    private void getUserDetails() {
        userModelSubscriberProxy = new SubscriberProxy<>(this);

        getUserUserCase = new GetUserUseCase(
                new UIThread(),
                "161339",
                new UserDataRepository(
                        new DataStoreFactory(this)
                        , new UserEntityDataMapper())
                , "2013214151");
//        this.initializeInjector("2013214151", "161339");
        this.getUserUserCase.execute(userModelSubscriberProxy);
    }

    @Override
    public void onCompleted() {
        Log.d("[DEBUG] ====> ", "onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        Log.e("[onError]", e.getMessage());
        Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNext(User user) {
        if (user != null) {
            userModelDataMapper = new UserModelDataMapper();
            UserModel userModel = userModelDataMapper.transform(user);
            vu.showOk(userModel);
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            this.finish();
        } else {
            Log.d("[DEBUG] ====> ", "onNextNull");
        }
    }

    private void initializeInjector(String stuNum, String idNum) {
        this.userComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .userModule(new UserModule(stuNum, idNum))
                .build();
        this.userComponent.inject(this);
    }
}
