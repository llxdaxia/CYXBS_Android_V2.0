package com.mredrock.cyxbs.data.rest;

import com.mredrock.cyxbs.common.Constants;
import com.mredrock.cyxbs.data.entities.CourseEntity;
import com.mredrock.cyxbs.data.entities.UserEntity;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Interface representing the DatabaseAPI endpoints
 * used by retrofit
 * <p>
 * Created by David on 15/5/16.
 */
public interface RestAPI {

    @FormUrlEncoded
    @POST(Constants.API_VERIFY)
    Observable<UserEntity.UserEntityWrapper> getUser(
            @Field("stuNum") String stuNum,
            @Field("idNum") String idNum);

    @FormUrlEncoded
    @Headers(Constants.HEADER)
    @POST(Constants.API_PERSON_SCHEDULE)
    Observable<List<CourseEntity>> getCourse(
            @Field("stuNum") String stuNum);

}
