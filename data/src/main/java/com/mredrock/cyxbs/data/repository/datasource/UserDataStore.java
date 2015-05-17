package com.mredrock.cyxbs.data.repository.datasource;

import com.mredrock.cyxbs.data.entities.UserEntity;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 * <p>
 * Created by David on 15/5/16.
 */
public interface UserDataStore {
    /**
     * Get an {@link rx.Observable} which will emit a {@link UserEntity.UserEntityWrapper}.
     *
     * @param stuNum The student number used to retrieve user data.
     * @param idNum  The id number used to retrieve user data.
     */
    Observable<UserEntity.UserEntityWrapper> getUser(final String stuNum, final String idNum);
}
