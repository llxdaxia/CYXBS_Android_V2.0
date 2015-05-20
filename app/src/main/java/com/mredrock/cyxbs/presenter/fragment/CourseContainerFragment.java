package com.mredrock.cyxbs.presenter.fragment;

import android.os.Bundle;

import com.mredrock.cyxbs.view.widget.tab.TabPagerAdapter;
import com.mredrock.cyxbs.view.widget.tab.TabPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 15/5/20.
 */
public class CourseContainerFragment extends TabPagerFragment<TabPagerAdapter> {


    private final List<String> titleList = new ArrayList<>();
    private final List<android.support.v4.app.Fragment> fragmentsList = new ArrayList<>();

    @Override
    protected TabPagerAdapter createAdapter() {
        return new TabPagerAdapter(this, fragmentsList, titleList);
    }

    public static CourseContainerFragment newInstance() {
        return new CourseContainerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titleList.add("第一周");
        titleList.add("第二周");
        titleList.add("第三周");
        titleList.add("第四周");
        titleList.add("第五周");
        titleList.add("第六周");
        titleList.add("第七周");
        titleList.add("第八周");
        titleList.add("第九周");
        titleList.add("第十周");
        titleList.add("第十一周");
        titleList.add("第十二周");
        titleList.add("第十三周");
        titleList.add("第十四周");
        titleList.add("第十五周");
        titleList.add("第十六周");
        titleList.add("第十七周");
        titleList.add("第十八周");
        titleList.add("第十九周");
        titleList.add("第二十周");
        for (int i = 0; i < 20; i++) {
            fragmentsList.add(new CourseFragment());
        }
    }
}
