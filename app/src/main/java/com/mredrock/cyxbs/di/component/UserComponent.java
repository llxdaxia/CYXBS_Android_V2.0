package com.mredrock.cyxbs.di.component;

import com.mredrock.cyxbs.di.modules.ActivityModule;
import com.mredrock.cyxbs.di.modules.UserModule;
import com.mredrock.cyxbs.di.scopes.PerActivity;
import com.mredrock.cyxbs.domain.repository.UserRepository;
import com.mredrock.cyxbs.presenter.activity.LoginActivity;

import dagger.Component;

/**
 * Created by David on 15/5/18.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class,
                UserModule.class
        })
public interface UserComponent extends ActivityComponent {
    void inject(LoginActivity loginActivity);

}
