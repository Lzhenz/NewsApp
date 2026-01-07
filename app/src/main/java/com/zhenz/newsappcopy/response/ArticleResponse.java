package com.zhenz.newsappcopy.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zhenz.newsappcopy.model.Article;

import java.util.List;

public class ArticleResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;

    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public void setTotalResults(Integer totalResults){
        this.totalResults = totalResults;
    }

    public Integer getTotalResults(){
        return totalResults;
    }

    public void setArticles(List<Article> articles){
        this.articles = articles;
    }

    public List<Article> getArticles(){
        return articles;
    }
}
