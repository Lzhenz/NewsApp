package com.zhenz.newsappcopy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhenz.newsappcopy.model.Article;
import com.zhenz.newsappcopy.response.ArticleResponse;

import java.util.ArrayList;

public class MovieArticleAdapter extends RecyclerView.Adapter{
    // data type
    private ArrayList<Article> articleArrayList;
    private Context context;

    // 构造函数，传递数据
    public MovieArticleAdapter( Context context , ArrayList<Article> articleArrayList){
        this.articleArrayList = articleArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
