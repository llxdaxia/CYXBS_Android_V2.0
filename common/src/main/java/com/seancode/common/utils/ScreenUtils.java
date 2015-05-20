package com.seancode.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;

import java.text.MessageFormat;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

/**
 * ScreenUtils
 */
public class ScreenUtils {

    private static int screenWidth = 0;
    private static int screenHeight = 0;

    private ScreenUtils() {
        throw new AssertionError();
    }

    public static float dp2Px(Context context, float dp) {
        if (context == null) {
            return -1;
        }
        return dp * context.getResources().getDisplayMetrics().density;
    }

    public static float px2Dp(Context context, float px) {
        if (context == null) {
            return -1;
        }
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float dp2PxInt(Context context, float dp) {
        return (int) (dp2Px(context, dp) + 0.5f);
    }

    public static float px2DpCeilInt(Context context, float px) {
        return (int) (px2Dp(context, px) + 0.5f);
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static int getScreenHeight(Context c) {
        if (screenHeight == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y;
        }
        return screenHeight;
    }

    public static int getScreenWidth(Context c) {
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }
        return screenWidth;
    }

    /**
     * Kevin Sawicki <kevinsawicki@gmail.com>'s wishLists
     */
    public static class Toaster {
        private static void show(final Activity activity, final int resId,
                                 final int duration) {
            if (activity == null)
                return;

            final Context context = activity.getApplication();
            activity.runOnUiThread(new Runnable() {

                public void run() {
                    Toast.makeText(context, resId, duration).show();
                }
            });
        }

        private static void show(final Activity activity, final String message,
                                 final int duration) {
            if (activity == null)
                return;
            if (TextUtils.isEmpty(message))
                return;

            final Context context = activity.getApplication();
            activity.runOnUiThread(new Runnable() {

                public void run() {
                    Toast.makeText(context, message, duration).show();
                }
            });
        }

        private static void show(final Context context, final String message,
                                 final int duration) {
            if (context == null)
                return;
            if (TextUtils.isEmpty(message))
                return;
            Toast.makeText(context,message,duration).show();
        }

        private static void show(final Context context, final int resId,
                                 final int duration) {
            if (context == null)
                return;
            Toast.makeText(context,resId,duration).show();
        }

        /**
         * Show message in {@link Toast} with {@link Toast#LENGTH_LONG} duration
         *
         * @param activity
         * @param resId
         */
        public static void showLong(final Activity activity, int resId) {
            show(activity, resId, LENGTH_LONG);
        }

        public static void showLong(final Context context, String message) {
            show(context, message, LENGTH_LONG);
        }

        /**
         * Show message in {@link Toast} with {@link Toast#LENGTH_SHORT} duration
         *
         * @param activity
         * @param resId
         */
        public static void showShort(final Activity activity, final int resId) {
            show(activity, resId, LENGTH_SHORT);
        }

        public static void showShort(final Context context, String message) {
            show(context, message, LENGTH_SHORT);
        }

        /**
         * Show message in {@link Toast} with {@link Toast#LENGTH_LONG} duration
         *
         * @param activity
         * @param message
         */
        public static void showLong(final Activity activity, final String message) {
            show(activity, message, LENGTH_LONG);
        }

        /**
         * Show message in {@link Toast} with {@link Toast#LENGTH_SHORT} duration
         *
         * @param activity
         * @param message
         */
        public static void showShort(final Activity activity, final String message) {
            show(activity, message, LENGTH_SHORT);
        }

        /**
         * Show message in {@link Toast} with {@link Toast#LENGTH_LONG} duration
         *
         * @param activity
         * @param message
         * @param args
         */
        public static void showLong(final Activity activity, final String message,
                                    final Object... args) {
            String formatted = MessageFormat.format(message, args);
            show(activity, formatted, LENGTH_LONG);
        }

        /**
         * Show message in {@link Toast} with {@link Toast#LENGTH_SHORT} duration
         *
         * @param activity
         * @param message
         * @param args
         */
        public static void showShort(final Activity activity, final String message,
                                     final Object... args) {
            String formatted = MessageFormat.format(message, args);
            show(activity, formatted, LENGTH_SHORT);
        }

        /**
         * Show message in {@link Toast} with {@link Toast#LENGTH_LONG} duration
         *
         * @param activity
         * @param resId
         * @param args
         */
        public static void showLong(final Activity activity, final int resId,
                                    final Object... args) {
            if (activity == null)
                return;

            String message = activity.getString(resId);
            showLong(activity, message, args);
        }

        /**
         * Show message in {@link Toast} with {@link Toast#LENGTH_SHORT} duration
         *
         * @param activity
         * @param resId
         * @param args
         */
        public static void showShort(final Activity activity, final int resId,
                                     final Object... args) {
            if (activity == null)
                return;

            String message = activity.getString(resId);
            showShort(activity, message, args);
        }
    }
}
