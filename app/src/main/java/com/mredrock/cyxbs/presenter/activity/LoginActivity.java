package com.mredrock.cyxbs.presenter.activity;

import android.util.Log;

import com.mredrock.cyxbs.UIThread;
import com.mredrock.cyxbs.data.mapper.UserEntityDataMapper;
import com.mredrock.cyxbs.data.mapper.UserModelDataMapper;
import com.mredrock.cyxbs.data.model.UserModel;
import com.mredrock.cyxbs.data.repository.UserDataRepository;
import com.mredrock.cyxbs.data.repository.datasource.DataStoreFactory;
import com.mredrock.cyxbs.domain.interactor.GetUserUseCase;
import com.mredrock.cyxbs.domain.model.User;
import com.mredrock.cyxbs.presenter.ISubcriber;
import com.mredrock.cyxbs.presenter.SubscriberProxy;
import com.mredrock.cyxbs.view.impl.LoginVu;

public class LoginActivity extends BasePresenterActivity<LoginVu> implements ISubcriber<User> {

    //    private UserComponent userComponent;
    SubscriberProxy<User> userModelSubscriberProxy;

    //    @Inject
    GetUserUseCase getUserUserCase;
//    @Inject
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
        this.getUserUserCase.execute(userModelSubscriberProxy);
    }

    @Override
    public void onCompleted() {
        Log.d("[DEBUG] ====> ", "onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onNext(User user) {
        userModelDataMapper = new UserModelDataMapper();
        UserModel userModel = userModelDataMapper.transform(user);
        vu.showOk(userModel);
    }

//    private void initializeInjector(){
//        this.userComponent = DaggerUserComponent.builder()
//                .applicationComponent(getApplicationComponent())
//                .activityModule(getActivityModule())
//                .build();
//        this.userComponent.inject(this);
//    }
}
