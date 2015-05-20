package com.mredrock.cyxbs.model.cache;

import rx.Observable;

/**
 * an interface of operating cache.
 * <p>
 * Created by David on 15/5/19.
 */
public interface Cache<T> {

    /**
     * Gets an {@link rx.Observable} which will emit a {@link T}.
     *
     * @param id The id (primary key) of the element to retrieve data.
     */
    Observable<T> get(final int id);

    /**
     * Puts and element into the cache.
     *
     * @param t Element to insert in the cache.
     */
    void put(T t);

    /**
     * Checks if an element exists in the cache.
     *
     * @param id The id (primary key) used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached(final int id);

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();

}
