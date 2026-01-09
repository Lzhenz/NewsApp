package com.zhenz.newsappcopy.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.zhenz.newsappcopy.repository.ArticleRepository;
import com.zhenz.newsappcopy.response.ArticleResponse;

import static com.zhenz.newsappcopy.constants.AppConstant.ARTICLE_QUERY;
import static com.zhenz.newsappcopy.constants.AppConstant.API_KEY;

public class ArticleViewModel extends AndroidViewModel {

    // 主要进行数据状态的绑定
    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getMovieArticles(ARTICLE_QUERY , API_KEY);
    }

    public LiveData<ArticleResponse> getArticleResponseLiveData(){
        return articleResponseLiveData;
    }

















}
