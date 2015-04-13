package com.mredrock.cyxbs.util;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.mredrock.cyxbs.R;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by david on 4/13/15.
 * email: yangcheng0816@gmail.com
 */
public class RetrofitUtils {
    public static void disErr(Context context, RetrofitError e) {
        switch (e.getKind()) {
            case NETWORK:
                Toaster.showShort(context, context.getString(R.string.network_error));
                break;
            case CONVERSION:
                Toaster.showShort(context, context.getString(R.string.network_conversion));
                break;
            case HTTP:
                switch (e.getResponse().getStatus()) {
                    case 500:
                        Toaster.showShort(context, e.getResponse().getReason() + ":" + context.getString(R.string.network_500));
                        break;
                    case 404:
                        Toaster.showShort(context, context.getString(R.string.network_404));
                        break;
                    default:
                        Toaster.showShort(context, context.getString(R.string.network_error_default)
                                + String.valueOf(e.getResponse().getStatus())
                                + e.getResponse().getReason());
                        break;
                }
                break;
            case UNEXPECTED:
                Toaster.showShort(context, context.getString(R.string.network_unexpected));
                break;
        }
    }

    public static void showError(Context context, String response) {
        Toaster.showShort(context,response);
    }

}
