package com.mredrock.cyxbs.model.repository;

import com.mredrock.cyxbs.domain.model.News;
import com.mredrock.cyxbs.domain.repository.NewsRepository;

import java.util.List;

import javax.inject.Singleton;

import rx.Observable;

/**
 * {@link NewsRepository} a repository for retrieving user data.
 * <p>
 * Created by David on 15/5/16.
 */
@Singleton
public class NewsDataRepository implements NewsRepository {
    //TODO
    @Override
    public Observable<List<News>> getNewses() {
        return null;
    }

    @Override
    public Observable<News> getNews(int newsId) {
        return null;
    }
}
