package com.seancode.common.utils;

import android.util.Log;

import com.mredrock.cyxbs.common.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Created by david on 15/4/12.
 * email: yangcheng0816@gmail.com
 * IO2014
 */
public class LogUtils {
    private static final String LOG_PREFIX = "cyxbs_";
    private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    private static final int MAX_LOG_TAG_LENGTH = 23;

    public static String makeLogTag(String str) {
        if (str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1);
        }

        return LOG_PREFIX + str;
    }

    /**
     * Don't use this when obfuscating class names!
     */
    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

    public static void LOGD(String message) {
        if (BuildConfig.DEBUG || Log.isLoggable(LOG_PREFIX, Log.DEBUG)) {
            Log.d(LOG_PREFIX, message);
        }
    }

    public static void LOGD(final String tag, String message) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, message);
        }
    }

    public static void LOGD(final String tag, String message, Throwable cause) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) {
            Log.v(tag, message, cause);
        }
    }

    public static void LOGV(String message) {
        if (BuildConfig.DEBUG || Log.isLoggable(LOG_PREFIX, Log.DEBUG)) {
            Log.v(LOG_PREFIX, message);
        }
    }

    public static void LOGV(final String tag, String message) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (BuildConfig.DEBUG && Log.isLoggable(tag, Log.VERBOSE)) {
            Log.v(tag, message);
        }
    }

    public static void LOGV(final String tag, String message, Throwable cause) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (BuildConfig.DEBUG && Log.isLoggable(tag, Log.VERBOSE)) {
            Log.v(tag, message, cause);
        }
    }

    public static void LOGI(String message) {
        if (BuildConfig.DEBUG || Log.isLoggable(LOG_PREFIX, Log.DEBUG)) {
            Log.i(LOG_PREFIX, message);
        }
    }

    public static void LOGI(final String tag, String message) {
        Log.i(tag, message);
    }

    public static void LOGI(final String tag, String message, Throwable cause) {
        Log.i(tag, message, cause);
    }

    public static void LOGW(String message) {
        if (BuildConfig.DEBUG || Log.isLoggable(LOG_PREFIX, Log.DEBUG)) {
            Log.w(LOG_PREFIX, message);
        }
    }

    public static void LOGW(final String tag, String message) {
        Log.w(tag, message);
    }

    public static void LOGW(final String tag, String message, Throwable cause) {
        Log.w(tag, message, cause);
    }

    public static void LOGE(String message) {
        if (BuildConfig.DEBUG || Log.isLoggable(LOG_PREFIX, Log.DEBUG)) {
            Log.e(LOG_PREFIX, message);
        }
    }

    public static void LOGE(final String tag, String message) {
        Log.e(tag, message);
    }

    public static void LOGE(final String tag, String message, Throwable cause) {
        Log.e(tag, message, cause);
    }

    public static void LOGJSON(String json){
        Logger.json(json);
    }

    private LogUtils() {
    }
}
