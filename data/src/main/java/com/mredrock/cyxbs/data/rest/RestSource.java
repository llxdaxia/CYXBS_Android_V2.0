package com.mredrock.cyxbs.data.rest;

import com.mredrock.cyxbs.data.entities.CourseEntity;
import com.mredrock.cyxbs.data.entities.NewsEntity;
import com.mredrock.cyxbs.data.entities.UserEntity;

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
    Observable<UserEntity.UserEntityWrapper> getUserEntityById(final String stuNum, final String idNum);

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
