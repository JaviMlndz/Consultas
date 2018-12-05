package com.example.cristian.consultas.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static final String BASE_URL = "http://138.68.59.197:8090";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){

        if (mInstance == null){
            mInstance = new RetrofitClient();
        }

        return mInstance;
    }

    public IApi getApi(){
        return retrofit.create(IApi.class);
    }
}
