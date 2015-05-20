package com.mredrock.cyxbs.model.mapper;

import com.mredrock.cyxbs.model.UserModel;
import com.mredrock.cyxbs.domain.model.User;

import javax.inject.Inject;

/**
 * Created by David on 15/5/17.
 */
public class UserModelDataMapper {

    @Inject
    public UserModelDataMapper() {
    }

    /**
     * Transform a {@link User} into an {@link UserModel}.
     *
     * @param user Object to be transformed.
     * @return {@link User} if valid {@link User} otherwise null.
     */
    public UserModel transform(User user) {
        UserModel userModel = null;
        if (user != null) {
            userModel = new UserModel();
            userModel.setClassNum(user.getClassNum());
            userModel.setCollege(user.getCollege());
            userModel.setGender(user.getGender());
            userModel.setStuNum(user.getStuNum());
            userModel.setMajor(user.getMajor());
            userModel.setGrade(user.getGrade());
            userModel.setIdNum(user.getIdNum());
            userModel.setName(user.getName());
        }

        return userModel;
    }
}
