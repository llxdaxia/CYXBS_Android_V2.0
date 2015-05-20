package com.mredrock.cyxbs.presenter.fragment;


import android.os.Bundle;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.widget.tab.TabPagerAdapter;
import com.mredrock.cyxbs.view.widget.tab.TabPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻界面的fragment容器
 */
public class NewsContainerFragment extends TabPagerFragment<TabPagerAdapter> {

    private final List<String> titleList = new ArrayList<>();
    private final List<android.support.v4.app.Fragment> fragmentsList = new ArrayList<>();

    @Override
    protected TabPagerAdapter createAdapter() {
        return new TabPagerAdapter(this, fragmentsList, titleList);
    }

    public static NewsContainerFragment newInstance() {
        return new NewsContainerFragment();
    }

    @Override
    protected int getContentView() {
        return R.layout.view_pager_with_tab_standard;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titleList.add("教务信息");
        titleList.add("通知公告");
        titleList.add("校务新闻");
        titleList.add("E彩鎏光");

        fragmentsList.add(new JWNewsFragment());
        fragmentsList.add(new GGNewsFragment());
        fragmentsList.add(new XWNewsFragment());
        fragmentsList.add(new ENewsFragment());

    }
}
