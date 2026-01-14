package com.zhenz.newsappcopy.view_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.zhenz.newsappcopy.common.Event;
import com.zhenz.newsappcopy.repository.ArticleRepository;
import com.zhenz.newsappcopy.response.ArticleResponse;

import static com.zhenz.newsappcopy.constants.AppConstant.ARTICLE_QUERY;
import static com.zhenz.newsappcopy.constants.AppConstant.API_KEY;

public class ArticleViewModel extends AndroidViewModel {

    // 主要进行数据状态的绑定
    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;
    // 跳转事件
    public final MutableLiveData<Event<Boolean>> navigateToDetailEvent = new MutableLiveData<>();

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getMovieArticles(ARTICLE_QUERY , API_KEY);
    }

    public LiveData<ArticleResponse> getArticleResponseLiveData(){
        return articleResponseLiveData;
    }

    public LiveData<Event<Boolean>> getNavigateToDetailEvent() {
        return navigateToDetailEvent;
    }

    public void onDetailButtonClick(){
        Log.d("VM", "emit navigate event: " + this);
        navigateToDetailEvent.setValue(new Event<>(true));
    }












}
