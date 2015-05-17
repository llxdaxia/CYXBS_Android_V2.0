package com.mredrock.cyxbs.data.repository;

import com.mredrock.cyxbs.data.entities.UserEntity;
import com.mredrock.cyxbs.data.mapper.UserEntityDataMapper;
import com.mredrock.cyxbs.data.repository.datasource.DataStoreFactory;
import com.mredrock.cyxbs.data.repository.datasource.UserDataStore;
import com.mredrock.cyxbs.domain.model.User;
import com.mredrock.cyxbs.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * {@link UserRepository} a repository for retrieving user data.
 * <p>
 * Created by David on 15/5/16.
 */
@Singleton
public class UserDataRepository implements UserRepository {

    private final DataStoreFactory factory;
    private final UserEntityDataMapper userEntityDataMapper;

    private final Func1<UserEntity.UserEntityWrapper, User> userDetailsEntityDataMapper = new Func1<UserEntity.UserEntityWrapper, User>() {
        @Override
        public User call(UserEntity.UserEntityWrapper userEntityWrapper) {
            return UserDataRepository.this.userEntityDataMapper.transform(userEntityWrapper);
        }
    };


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
        return userDataStore.getUser(stuNum, idNum).map(userDetailsEntityDataMapper);
    }
}
