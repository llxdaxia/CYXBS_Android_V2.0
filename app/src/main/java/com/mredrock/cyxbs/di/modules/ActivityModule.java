package com.mredrock.cyxbs.di.modules;

import android.app.Activity;

import com.mredrock.cyxbs.di.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * A module to wrap the Activity state and expose it to the graph.
 * Created by David on 15/5/12.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }


    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity providesActivity(){
        return this.activity;
    }
}
