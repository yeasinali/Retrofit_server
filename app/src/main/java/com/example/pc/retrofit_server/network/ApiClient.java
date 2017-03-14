package com.example.pc.retrofit_server.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pc on 3/10/2017.
 */

public class ApiClient {
    public static  final String BASE_URL = "http://192.168.0.100";
    private  static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
                    }
        return retrofit;
    }

    public static Retrofit setRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
