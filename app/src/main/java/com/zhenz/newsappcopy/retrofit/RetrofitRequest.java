package com.zhenz.newsappcopy.retrofit;

import com.zhenz.newsappcopy.constants.AppConstant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {

    private static Retrofit retrofit;

    // todo:delete
    // public final static String BASE_URL = "https://newsapi.org/";;
    // nothing to return
    public RetrofitRequest(){}
    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
