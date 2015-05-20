package com.mredrock.cyxbs.model.repository.datasource;

import com.mredrock.cyxbs.model.entities.UserEntity;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 * <p>
 * Created by David on 15/5/16.
 */
public interface UserDataStore {
    /**
     * Get an {@link rx.Observable} which will emit a {@link UserEntity}.
     *
     * @param stuNum The student number used to retrieve user data.
     * @param idNum  The id number used to retrieve user data.
     */
    Observable<UserEntity> getUser(final String stuNum, final String idNum);
}
