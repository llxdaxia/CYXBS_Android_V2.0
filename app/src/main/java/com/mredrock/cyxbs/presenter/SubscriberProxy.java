package com.mredrock.cyxbs.presenter;

import com.mredrock.cyxbs.domain.interactor.DefaultSubscriber;

/**
 * Created by David on 15/5/17.
 */
public class SubscriberProxy<T> extends DefaultSubscriber<T> {
    ISubcriber subcriber;

    public SubscriberProxy(ISubcriber subcriber) {
        this.subcriber = subcriber;
    }

    @Override
    public void onCompleted() {
        subcriber.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        subcriber.onError(e);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onNext(T t) {
        subcriber.onNext(t);
    }
}
