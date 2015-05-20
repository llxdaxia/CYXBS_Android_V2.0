package com.mredrock.cyxbs.domain.repository;

import com.mredrock.cyxbs.domain.model.News;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link News} related data.
 * <p>
 * Created by David on 15/5/16.
 */
public interface NewsRepository extends Repository {

    /**
     * Get an {@link rx.Observable} which will emit a List of {@link News}.
     */
    Observable<List<News>> getNewses();

    /**
     * Get an {@link rx.Observable} which will emit a {@link News}.
     *
     * @param newsId The user id used to retrieve user data.
     */
    Observable<News> getNews(int newsId);

}
