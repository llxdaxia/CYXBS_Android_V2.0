package com.mredrock.cyxbs.domain.interactor;

import com.mredrock.cyxbs.domain.executor.PostExecutionThread;
import com.mredrock.cyxbs.domain.model.Course;
import com.mredrock.cyxbs.domain.repository.CourseRepository;

import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link Course}.
 * <p>
 * Created by David on 15/5/16.
 */
public class GetCoursesUseCase extends UseCase {
    private CourseRepository courseRepository;
    private final String stuNum;

    public GetCoursesUseCase(PostExecutionThread postExecutionThread, String stuNum) {
        super(postExecutionThread);
        this.stuNum = stuNum;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.courseRepository.getCourses(this.stuNum);
    }
}
