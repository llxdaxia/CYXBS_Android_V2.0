package com.mredrock.cyxbs.data.repository.datasource;

import com.mredrock.cyxbs.data.entities.UserEntity;
import com.mredrock.cyxbs.data.rest.RestSource;

import rx.Observable;

/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 * <p>
 * Created by David on 15/5/16.
 */
public class CloudUserDataStore implements UserDataStore {
    private final RestSource restSource;

    public CloudUserDataStore(RestSource restSource) {
        this.restSource = restSource;
    }

    @Override
    public Observable<UserEntity> getUser(String stuNum, String idNum) {
        return restSource.getUserEntityById(stuNum, idNum);
    }

}
