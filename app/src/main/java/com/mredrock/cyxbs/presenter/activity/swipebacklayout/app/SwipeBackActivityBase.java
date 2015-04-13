package com.mredrock.cyxbs.presenter.activity.swipebacklayout.app;


import com.mredrock.cyxbs.presenter.activity.swipebacklayout.SwipeBackLayout;

/**
 * @author Yrom
 */
public interface SwipeBackActivityBase {
    /**
     * @return the SwipeBackLayout associated with this activity.
     */
    public SwipeBackLayout getSwipeBackLayout();

    public void setSwipeBackEnable(boolean enable);

    /**
     * Scroll out contentView and finish the activity
     */
    public void scrollToFinishActivity();

}
