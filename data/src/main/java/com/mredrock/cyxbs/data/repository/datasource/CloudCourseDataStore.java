package com.mredrock.cyxbs.data.repository.datasource;

import com.mredrock.cyxbs.data.entities.CourseEntity;
import com.mredrock.cyxbs.data.rest.RestSource;

import java.util.List;

import rx.Observable;

/**
 * Created by David on 15/5/16.
 */
public class CloudCourseDataStore implements CourseDataStore {

    private final RestSource restSource;

    public CloudCourseDataStore(RestSource restSource) {
        this.restSource = restSource;
    }

    @Override
    public Observable<List<CourseEntity>> getCourse(String stuNum) {
        return restSource.getCourseEntityById(stuNum);
    }
}
