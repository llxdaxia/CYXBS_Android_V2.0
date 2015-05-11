package com.mredrock.cyxbs;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp.OkHttpImagePipelineConfigFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by david on 15/4/12.
 */
public class CyxbsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        okFresco();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }

    private void okFresco(){
        OkHttpClient ok = new OkHttpClient();
        ImagePipelineConfig config = OkHttpImagePipelineConfigFactory
                .newBuilder(this,ok)
                .build();
        Fresco.initialize(this,config);
    }
}
