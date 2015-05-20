package com.mredrock.cyxbs;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.mredrock.cyxbs.di.component.ApplicationComponent;
import com.mredrock.cyxbs.di.component.DaggerApplicationComponent;
import com.mredrock.cyxbs.di.modules.ApplicationModule;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by david on 15/4/12.
 */
public class CyxbsApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        okFresco();
        ActiveAndroid.initialize(this);
        this.initializeInjector();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }

    private void okFresco() {
        OkHttpClient ok = new OkHttpClient();
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
                .newBuilder(this, ok)
                .build();
        Fresco.initialize(this, config);
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
