package com.mredrock.cyxbs.domain.interactor;

import com.mredrock.cyxbs.domain.executor.PostExecutionThread;
import com.mredrock.cyxbs.domain.repository.NewsRepository;
import com.mredrock.cyxbs.domain.model.News;

import rx.Observable;

/**
 * This class is an implementation of {@link News} that represents a use case for
 * retrieving a collection of all {@link News}.
 * <p>
 * Created by David on 15/5/16.
 */
public class GetNewsListUseCase extends UseCase {
    private final NewsRepository newsRepository;

    public GetNewsListUseCase(
            PostExecutionThread postExecutionThread,
            NewsRepository newsRepository) {
        super(postExecutionThread);
        this.newsRepository = newsRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.newsRepository.getNewses();
    }
}
