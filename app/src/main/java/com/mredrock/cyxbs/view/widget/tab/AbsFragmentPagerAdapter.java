package com.mredrock.cyxbs.view.widget.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by David on 15/5/20.
 */
public abstract class AbsFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter implements FragmentProvider {

    private final AppCompatActivity activity;

    private final FragmentManager fragmentManager;

    private final Set<String> tags = new HashSet<>();
    private Fragment selected;

    /**
     * @param activity an instance of AppCompatActivity.
     */
    public AbsFragmentPagerAdapter(AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());

        fragmentManager = activity.getSupportFragmentManager();
        this.activity = activity;
    }

    public AbsFragmentPagerAdapter(Fragment fragment) {
        super(fragment.getChildFragmentManager());

        fragmentManager = fragment.getChildFragmentManager();
        this.activity = (AppCompatActivity) fragment.getActivity();
    }


    public boolean isEmpty() {
        return tags.isEmpty();
    }


    /**
     * This methods clears any fragments that may not apply to the newly
     * selected org.
     *
     * @return this adapter
     */
    public AbsFragmentPagerAdapter clearAdapter() {
        if (tags.isEmpty())
            return this;

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        for (String tag : tags) {
            Fragment fragment = fragmentManager.findFragmentByTag(tag);
            if (fragment != null)
                transaction.remove(fragment);
        }
        transaction.commit();
        tags.clear();

        return this;
    }

    @Override
    public Fragment getSelected() {
        return selected;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        if (fragment instanceof Fragment)
            tags.add(((Fragment) fragment).getTag());
        return fragment;
    }


    @Override
    public void setPrimaryItem(final ViewGroup container, final int position,
                               final Object object) {
        super.setPrimaryItem(container, position, object);

        boolean changed = false;
        if (object instanceof Fragment) {
            changed = object != selected;
            selected = (Fragment) object;
        } else {
            changed = object != null;
            selected = null;
        }

        if (changed)
            activity.invalidateOptionsMenu();
    }

}
