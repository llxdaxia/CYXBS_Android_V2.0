package com.mredrock.cyxbs.domain.interactor;

import com.mredrock.cyxbs.domain.executor.PostExecutionThread;
import com.mredrock.cyxbs.domain.repository.NewsRepository;

import rx.Observable;

/**
 * Created by David on 15/5/16.
 */
public class GetNewsDetailsUseCase extends UseCase {

    private final int            newsId;
    private final NewsRepository newsRepository;

    public GetNewsDetailsUseCase(
            int                 newsId,
            PostExecutionThread postExecutionThread,
            NewsRepository      newsRepository) {
        super(postExecutionThread);
        this.newsId = newsId;
        this.newsRepository = newsRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.newsRepository.getNews(newsId);
    }
}
