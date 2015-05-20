package com.mredrock.cyxbs.presenter.fragment;


import android.os.Bundle;

import com.mredrock.cyxbs.R;
import com.mredrock.cyxbs.view.widget.tab.TabPagerAdapter;
import com.mredrock.cyxbs.view.widget.tab.TabPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 各种成绩查询界面的Fragment容器
 */
public class InquiryContainerFragment extends TabPagerFragment<TabPagerAdapter> {


    private final List<String> titleList = new ArrayList<>();
    private final List<android.support.v4.app.Fragment> fragmentsList = new ArrayList<>();

    @Override
    protected TabPagerAdapter createAdapter() {
        return new TabPagerAdapter(this, fragmentsList, titleList);
    }

    public static InquiryContainerFragment newInstance() {
        return new InquiryContainerFragment();
    }

    @Override
    protected int getContentView() {
        return R.layout.view_pager_with_tab_standard;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titleList.add("空教室查询");
        titleList.add("考试查询");
        titleList.add("成绩查询");
        titleList.add("补考查询");

        fragmentsList.add(new ClassRoomFragment());
        fragmentsList.add(new ExamFragment());
        fragmentsList.add(new GradeFragment());
        fragmentsList.add(new ExamFragment());
    }
}
