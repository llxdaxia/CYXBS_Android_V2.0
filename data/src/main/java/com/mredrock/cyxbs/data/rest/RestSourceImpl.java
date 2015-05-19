package com.mredrock.cyxbs.data.rest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.mredrock.cyxbs.common.Constants;
import com.mredrock.cyxbs.data.entities.CourseEntity;
import com.mredrock.cyxbs.data.entities.NewsEntity;
import com.mredrock.cyxbs.data.entities.UserEntity;
import com.mredrock.cyxbs.data.entities.Wrapper;
import com.mredrock.cyxbs.data.exception.NotFoundException;

import java.util.List;

import retrofit.RestAdapter;
import rx.Observable;
import rx.exceptions.OnErrorThrowable;

/**
 * 真的不晓得要咋个命名了
 * {@link RestSource} implementation for retrieving data from the network.
 * <p>
 * Created by David on 15/5/16.
 */
public class RestSourceImpl implements RestSource {

    private RestAPI restApi;
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

        restApi = apiRest.create(RestAPI.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable<UserEntity> getUserEntityById(String stuNum, String idNum) {
        return restApi.getUser(stuNum, idNum).map(userEntityWrapper -> check(userEntityWrapper, userEntityWrapper.getData()));
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

    private <T> T check(Wrapper w, T t) {
        if (t == null) {
            throw new NotFoundException(w.getInfo());
        } else {
            return t;
        }
    }
}
