package com.mredrock.cyxbs.domain.repository;

import com.mredrock.cyxbs.domain.model.User;

import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link User} related data.
 * <p>
 * Created by David on 15/5/16.
 */
public interface UserRepository {
    /**
     * Get an {@link rx.Observable} which will emit a {@link User}.
     *
     * @param stuNum The student number used to retrieve user data.
     * @param idNum  The id number used to retrieve user data.
     */
    Observable<User> getUser(final String stuNum, final String idNum);
}
