package com.mredrock.cyxbs.domain.interactor;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 * <p>
 * Created by David on 15/5/15.
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {
    @Override
    public void onCompleted() {
        // no-op by default.
    }

    @Override
    public void onError(Throwable e) {
        // no-op by default.
    }

    @Override
    public void onNext(T t) {
        // no-op by default.
    }
}