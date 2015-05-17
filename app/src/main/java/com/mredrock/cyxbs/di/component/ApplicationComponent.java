package com.mredrock.cyxbs.di.component;

import android.app.Activity;
import android.content.Context;

import com.mredrock.cyxbs.di.modules.ApplicationModule;
import com.mredrock.cyxbs.domain.executor.PostExecutionThread;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 * Created by David on 15/5/12.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(Activity activity);
    
    //Exposed to sub-graphs.
    Context context();
    PostExecutionThread postExecutionThread();
}
