package com.mredrock.cyxbs.domain.repository;

import com.mredrock.cyxbs.domain.model.Course;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link Course} related data.
 * <p>
 * Created by David on 15/5/16.
 */
public interface CourseRepository extends Repository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link Course}.
     */
    Observable<List<Course>> getCourses(String stuNum);
}
