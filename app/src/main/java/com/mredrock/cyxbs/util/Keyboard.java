package com.mredrock.cyxbs.util;

import static android.content.Context.INPUT_METHOD_SERVICE;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Kevin Sawicki <kevinsawicki@gmail.com>'s wishLists
 */
public class Keyboard {
    /**
     * Hide soft input method manager
     *
     * @param view
     * @return view
     */
    public static View hideSoftInput(final View view) {
        InputMethodManager manager = (InputMethodManager) view.getContext()
                .getSystemService(INPUT_METHOD_SERVICE);
        if (manager != null)
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        return view;
    }
}
