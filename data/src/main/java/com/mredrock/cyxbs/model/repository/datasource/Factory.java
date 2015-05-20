package com.mredrock.cyxbs.model.repository.datasource;

import android.content.Context;

/**
 * Created by David on 15/5/16.
 */
public abstract class Factory {

    final Context context;

    public Factory(Context context) {
        this.context = context;
    }

    public abstract UserDataStore createCloudUserDataStore(String stuNum, String idNum);

    public abstract NewsDataStore createCloudNewsDataStore();

    public abstract CourseDataStore createCloudCourseDataStore(String stuNum);

}
