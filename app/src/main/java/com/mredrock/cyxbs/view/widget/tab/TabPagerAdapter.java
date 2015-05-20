package com.mredrock.cyxbs.view.widget.tab;

import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import java.util.List;

/**
 * pagerAdapter for tab
 * <p>
 * Created by David on 15/5/20.
 */
public class TabPagerAdapter extends AbsFragmentPagerAdapter {

    private final List<String> titleList;
    private final List<android.support.v4.app.Fragment> fragmentsList;

    public TabPagerAdapter(final Fragment fragment, List<android.support.v4.app.Fragment> fragmentsList, List<String> titleList) {
        super(fragment);
        this.fragmentsList = fragmentsList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return (fragmentsList == null || fragmentsList.size() == 0) ? null : fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList == null ? 0 : fragmentsList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (titleList.size() > position) ? titleList.get(position) : "";
    }

}
