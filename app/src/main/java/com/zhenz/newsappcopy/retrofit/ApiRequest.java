package com.zhenz.newsappcopy.retrofit;

import com.zhenz.newsappcopy.repository.ArticleRepository;
import com.zhenz.newsappcopy.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("v2/everything/")
    Call<ArticleResponse> getMovieArticles(
        @Query("q") String query,
        @Query("apikey") String key
    );
}
