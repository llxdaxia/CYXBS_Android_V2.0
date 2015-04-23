package com.mredrock.cyxbs.presenter;

/**
 * Created by David on 15/4/22.
 */
public interface IPresenter<V> {
    Class<V> getVuClass();

    void onBindVu();

    void onDestroyVu();
}
