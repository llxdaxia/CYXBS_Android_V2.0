package com.mredrock.cyxbs.di.component;

import android.app.Activity;

import com.mredrock.cyxbs.di.scopes.PerActivity;
import com.mredrock.cyxbs.di.modules.ActivityModule;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * <p>
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link PerActivity}
 * Created by David on 15/5/12.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
