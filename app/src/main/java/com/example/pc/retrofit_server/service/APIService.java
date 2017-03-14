package com.example.pc.retrofit_server.service;

import com.example.pc.retrofit_server.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by pc on 3/10/2017.
 */

public interface APIService {
    @GET("volley_server/show_json.php")
    Call<List<User>> getUserData();

    @FormUrlEncoded
    @POST("/volley_server/registan.php")
    Call<User> insertuserInfo( @Field("name") String name, @Field("email") String email, @Field("phone") String phone);


}
