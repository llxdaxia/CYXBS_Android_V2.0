package com.mredrock.cyxbs.presenter;

/**
 * 抽象了P层的所有共同方法的接口
 * Created by David on 15/4/22.
 */
public interface IPresenter<V> {
    Class<V> getVuClass();

    void onBindVu();

    void onDestroyVu();
}
