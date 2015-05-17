package com.mredrock.cyxbs.data.mapper;

import com.mredrock.cyxbs.data.entities.UserEntity;
import com.mredrock.cyxbs.domain.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link UserEntity} (in the data layer) to {@link User} in the
 * domain layer.
 * <p>
 * Created by David on 15/5/16.
 */
@Singleton
public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper() {
    }

    /**
     * Transform a {@link UserEntity.UserEntityWrapper} into an {@link User}.
     *
     * @param userEntityWrapper Object to be transformed.
     * @return {@link User} if valid {@link UserEntity.UserEntityWrapper} otherwise null.
     */
    public User transform(UserEntity.UserEntityWrapper userEntityWrapper) {
        User user = null;
        if (userEntityWrapper != null) {
            UserEntity userEntity = userEntityWrapper.getData();
            user = new User();
            user.setClassNum(userEntity.getClassNum());
            user.setCollege(userEntity.getCollege());
            user.setGender(userEntity.getGender());
            user.setStuNum(userEntity.getStuNum());
            user.setMajor(userEntity.getMajor());
            user.setGrade(userEntity.getGrade());
            user.setIdNum(userEntity.getIdNum());
            user.setName(userEntity.getName());
        }

        return user;
    }
}
