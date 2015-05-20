package com.mredrock.cyxbs.presenter;

/**
 * Created by David on 15/5/17.
 */
public interface ISubcriber<T> {
    void onCompleted();

    void onError(Throwable e);

    void onNext(T t);
}
