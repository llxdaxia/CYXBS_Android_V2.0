package com.mredrock.cyxbs.di.modules;

import com.mredrock.cyxbs.di.scopes.PerActivity;
import com.mredrock.cyxbs.domain.executor.PostExecutionThread;
import com.mredrock.cyxbs.domain.interactor.GetUserUseCase;
import com.mredrock.cyxbs.domain.interactor.UseCase;
import com.mredrock.cyxbs.domain.repository.UserRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by David on 15/5/18.
 */
@Module
public class UserModule {
    private String stuNum;
    private String idNum;

    public UserModule() {
    }

    public UserModule(String idNum, String stuNum) {
        this.idNum = idNum;
        this.stuNum = stuNum;
    }

    @Provides
    @PerActivity
    UseCase providesGetUserUseCase(PostExecutionThread postExecutionThread, UserRepository userRepository) {
        return new GetUserUseCase(postExecutionThread, this.idNum, userRepository, stuNum);
    }

}
