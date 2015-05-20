package com.mredrock.cyxbs.model.rest;

import com.mredrock.cyxbs.model.entities.CourseEntity;
import com.mredrock.cyxbs.model.entities.NewsEntity;
import com.mredrock.cyxbs.model.entities.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * RestSource for retrieving data from the network.
 * <p>
 * Created by David on 15/5/16.
 */
public interface RestSource {
    /**
     * Retrieves an {@link rx.Observable} which will emit a {@link UserEntity.UserEntityWrapper}.
     *
     * @param stuNum The user id used to get user data.
     * @param idNum  The user passwd used to get user date.
     */
    Observable<UserEntity> getUserEntityById(final String stuNum, final String idNum);

    /**
     * Retrieves an {@link rx.Observable} which will emit a {@link CourseEntity}.
     *
     * @param stuNum The user id used to get user data.
     */
    Observable<List<CourseEntity>> getCourseEntityById(final String stuNum);

    /**
     * Retrieves an {@link rx.Observable} which will emit a {@link NewsEntity}.
     *
     * @param page The page used to get news data.
     */
    Observable<NewsEntity> getNewsEntity(final String page);
}
