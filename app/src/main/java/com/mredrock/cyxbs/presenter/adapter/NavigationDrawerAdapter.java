package com.mredrock.cyxbs.presenter.adapter;

import com.mredrock.cyxbs.view.impl.NavItemVu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 15/4/25.
 */
public class NavigationDrawerAdapter extends BasePresenterAdapter<NavItemVu> {
    List<String> items = new ArrayList<>();

    public NavigationDrawerAdapter() {
        items.add("课表");
        items.add("安排");
        items.add("资讯");
        items.add("查询");
        items.add("发现");
    }

    @Override
    protected void onBindListItemVu(int position) {
        vu.setItemText(items.get(position));
    }

    @Override
    protected Class<NavItemVu> getVuClass() {
        return NavItemVu.class;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
