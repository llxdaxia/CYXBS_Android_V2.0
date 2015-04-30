package com.mredrock.cyxbs.presenter.fragment;


import com.mredrock.cyxbs.view.impl.NewsContainerVu;

/**
 * 新闻界面的fragment容器
 */
public class NewsContainerFragment extends BasePresenterFragment<NewsContainerVu> {

    public NewsContainerFragment() {
    }

    @Override
    public Class<NewsContainerVu> getVuClass() {
        return NewsContainerVu.class;
    }

    @Override
    public void onBindVu() {

    }

    public static NewsContainerFragment newInstance(){
        return new NewsContainerFragment();
    }
}
