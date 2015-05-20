package com.mredrock.cyxbs.di.modules;

import android.content.Context;

import com.mredrock.cyxbs.CyxbsApplication;
import com.mredrock.cyxbs.UIThread;
import com.mredrock.cyxbs.model.repository.UserDataRepository;
import com.mredrock.cyxbs.domain.executor.PostExecutionThread;
import com.mredrock.cyxbs.domain.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 * Created by David on 15/5/12.
 */
@Module
public class ApplicationModule {
    private final CyxbsApplication application;

    public ApplicationModule(CyxbsApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    PostExecutionThread providesPostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Provides
    @Singleton
    UserRepository providesUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
