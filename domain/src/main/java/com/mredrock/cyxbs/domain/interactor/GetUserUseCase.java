package com.mredrock.cyxbs.domain.interactor;

import com.mredrock.cyxbs.domain.executor.PostExecutionThread;
import com.mredrock.cyxbs.domain.model.User;
import com.mredrock.cyxbs.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving data related to an specific {@link User}.
 *
 * Created by David on 15/5/17.
 */
public class GetUserUseCase extends UseCase {

    private final UserRepository userRepository;
    private final String         stuNum;
    private final String         idNum;

    @Inject
    public GetUserUseCase(PostExecutionThread postExecutionThread, String idNum, UserRepository userRepository, String stuNum) {
        super(postExecutionThread);
        this.idNum = idNum;
        this.userRepository = userRepository;
        this.stuNum = stuNum;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.userRepository.getUser(this.stuNum, this.idNum);
    }
}
