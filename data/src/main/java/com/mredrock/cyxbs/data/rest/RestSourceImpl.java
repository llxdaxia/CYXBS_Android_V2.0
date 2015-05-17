package com.mredrock.cyxbs.data.rest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.mredrock.cyxbs.common.Constants;
import com.mredrock.cyxbs.data.entities.CourseEntity;
import com.mredrock.cyxbs.data.entities.NewsEntity;
import com.mredrock.cyxbs.data.entities.UserEntity;
import com.mredrock.cyxbs.model.BuildConfig;
import com.orhanobut.logger.Logger;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;

/**
 * 真的不晓得要咋个命名了
 * {@link RestSource} implementation for retrieving data from the network.
 * <p>
 * Created by David on 15/5/16.
 */
public class RestSourceImpl implements RestSource {

    private RestApi restApi;
    private Context context;

    public RestSourceImpl(Context context) {
        this(context, Constants.END_POINT_REDROCK);
    }

    public RestSourceImpl(Context context, String endPoint) {
        this.context = context;

        RestAdapter apiRest = new RestAdapter.Builder()
                .setEndpoint(endPoint)
                .setConverter(new FastjsonConverter())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        restApi = apiRest.create(RestApi.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable<UserEntity.UserEntityWrapper> getUserEntityById(String stuNum, String idNum) {
        return restApi.getUser(stuNum, idNum);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable<List<CourseEntity>> getCourseEntityById(String stuNum) {
        return restApi.getCourse(stuNum);
    }

    @Override
    public Observable<NewsEntity> getNewsEntity(String page) {
        return null;
    }


    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
