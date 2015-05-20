package com.mredrock.cyxbs.model.repository;

import com.mredrock.cyxbs.model.mapper.UserEntityDataMapper;
import com.mredrock.cyxbs.model.repository.datasource.DataStoreFactory;
import com.mredrock.cyxbs.model.repository.datasource.UserDataStore;
import com.mredrock.cyxbs.domain.model.User;
import com.mredrock.cyxbs.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * {@link UserRepository} a repository for retrieving user data.
 * <p>
 * Created by David on 15/5/16.
 */
@Singleton
public class UserDataRepository implements UserRepository {

    private final DataStoreFactory factory;
    private final UserEntityDataMapper userEntityDataMapper;

    /**
     * Constructs a {@link UserRepository}.
     *
     * @param factory              A factory to construct different data source implementations.
     * @param userEntityDataMapper {@link UserEntityDataMapper}.
     */
    @Inject
    public UserDataRepository(DataStoreFactory factory
            , UserEntityDataMapper userEntityDataMapper) {
        this.factory = factory;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable<User> getUser(String stuNum, String idNum) {
        final UserDataStore userDataStore = this.factory.createCloudUserDataStore(stuNum, idNum);
        return userDataStore.getUser(stuNum, idNum).map(UserDataRepository.this.userEntityDataMapper::transform);
    }
}
