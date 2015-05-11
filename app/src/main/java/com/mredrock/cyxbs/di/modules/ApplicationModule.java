package com.mredrock.cyxbs.di.modules;

import android.content.Context;

import com.mredrock.cyxbs.CyxbsApplication;

import javax.inject.Singleton;

import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 * Created by David on 15/5/12.
 */
public class ApplicationModule {
    private CyxbsApplication application;

    public ApplicationModule(CyxbsApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }
}
