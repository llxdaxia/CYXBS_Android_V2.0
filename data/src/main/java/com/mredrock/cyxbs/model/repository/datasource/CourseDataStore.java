package com.mredrock.cyxbs.model.repository.datasource;

import com.mredrock.cyxbs.model.entities.CourseEntity;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 * <p>
 * Created by David on 15/5/16.
 */
public interface CourseDataStore {
    /**
     * Get an {@link rx.Observable} which will emit a {@link CourseEntity}.
     *
     * @param stuNum The student number used to retrieve user data.
     */
    Observable<List<CourseEntity>> getCourse(final String stuNum);

}
