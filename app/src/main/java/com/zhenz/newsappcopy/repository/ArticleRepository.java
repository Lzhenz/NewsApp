package com.zhenz.newsappcopy.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.zhenz.newsappcopy.response.ArticleResponse;
import com.zhenz.newsappcopy.retrofit.ApiRequest;
import com.zhenz.newsappcopy.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {

    private final static String TAG = ArticleRepository.class.getSimpleName();

    // 使用 retrofit 进行调用
    private ApiRequest apiRequest;

    public ArticleRepository(){
        // 初始化 retrofit
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    // 开始获取文章数据并且返回
    public LiveData<ArticleResponse> getMovieArticles(String query , String key){
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        // 调用apiRequest查询数据并且处理返回
        apiRequest.getMovieArticles(query , key).
                enqueue(new Callback<ArticleResponse>() {
                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                        Log.d(TAG , "the response is : " + response);

                        // setData
                        if (response.body() != null){
                            data.setValue(response.body());

                            Log.d(TAG,"article total is : " + response.body().getTotalResults());
                            Log.d(TAG,"article size : " + response.body().getArticles().size());
                            Log.d(TAG,"article title pos 0 : " + response.body().getArticles().get(0).getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
                        // failure
                        data.setValue(null);
                    }
                });

        return data;
    }



























}
