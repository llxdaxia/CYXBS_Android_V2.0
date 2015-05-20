package com.mredrock.cyxbs.model.repository.datasource;

import com.mredrock.cyxbs.model.entities.CourseEntity;
import com.mredrock.cyxbs.model.rest.RestSource;

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
