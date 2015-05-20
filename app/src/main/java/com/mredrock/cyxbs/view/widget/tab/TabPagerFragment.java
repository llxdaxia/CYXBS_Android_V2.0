package com.mredrock.cyxbs.view.widget.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.mredrock.cyxbs.R;
import com.seancode.common.utils.ViewUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by David on 15/5/19.
 */
public abstract class TabPagerFragment<A extends PagerAdapter & FragmentProvider> extends PagerFragment implements TabHost.OnTabChangeListener, TabHost.TabContentFactory {
    @InjectView(R.id.tab_strip)
    PagerSlidingTabStrip tabs;

    @InjectView(R.id.view_pager)
    ViewPager pager;

    /**
     * Pager adapter
     */
    protected A adapter;

    /**
     * Get content view to be used when {@link #onCreateView} is called
     *
     * @return layout resource id
     */
    protected int getContentView() {
        return R.layout.view_pager_with_tab_newsstand;
    }

    @Override
    public void onPageSelected(final int position) {
        super.onPageSelected(position);
    }

    @Override
    public void onTabChanged(String tabId) {
    }

    @Override
    public View createTabContent(String tag) {
        return ViewUtils.setGone(new View(getActivity().getApplication()), true);
    }

    /**
     * Create pager adapter
     *
     * @return pager adapter
     */
    protected abstract A createAdapter();


    private void createPager() {
        adapter = createAdapter();
        getActivity().supportInvalidateOptionsMenu();
        pager.setAdapter(adapter);
        //给viewpager设置里面的fragment缓存为所有
        pager.setOffscreenPageLimit(adapter.getCount());
        tabs.setViewPager(pager);
    }

    @Override
    protected FragmentProvider getProvider() {
        return adapter;
    }

    /**
     * Configure tabs and pager
     */
    protected void configureTabPager() {
        createPager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getContentView(), null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        configureTabPager();
    }
}
