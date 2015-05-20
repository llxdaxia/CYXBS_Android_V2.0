package com.mredrock.cyxbs.model.repository.datasource;

import android.content.Context;

import com.mredrock.cyxbs.model.rest.RestSource;
import com.mredrock.cyxbs.model.rest.RestSourceImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 * <p>
 * Created by David on 15/5/16.
 */
@Singleton
public class DataStoreFactory extends Factory {

    RestSource restSource;

    @Inject
    public DataStoreFactory(Context context) {
        super(context);
    }

    @Override
    public UserDataStore createCloudUserDataStore(String stuNum, String idNum) {
        restSource = new RestSourceImpl(super.context);

        return new CloudUserDataStore(restSource);
    }

    @Override
    public NewsDataStore createCloudNewsDataStore() {
        return null;
    }

    @Override
    public CourseDataStore createCloudCourseDataStore(String stuNum) {
        restSource = new RestSourceImpl(super.context);
        return new CloudCourseDataStore(restSource);
    }
}
