package com.zhenz.newsappcopy.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhenz.newsappcopy.R;
import com.zhenz.newsappcopy.adapter.MovieArticleAdapter;
import com.zhenz.newsappcopy.model.Article;
import com.zhenz.newsappcopy.response.ArticleResponse;
import com.zhenz.newsappcopy.view_model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

// 目前对于xml的视图代码，AppCompatActivity依旧是最优解
public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    // 定义xml中的类型，一共是三个
    private ProgressBar progress_circular_movie_article;
    private RecyclerView my_recycler_view;
    private LinearLayoutManager layoutManager;

    // 定义adapter
    private MovieArticleAdapter adapter;

    // 定义当前activity的使用的数据类型
    private ArrayList<Article> articleArraylist =  new ArrayList<>();

    // todo:after define
    ArticleViewModel articleViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activate_main);

        // get init
        initialization();

        // get data
        getMovieArticles();
    }


    /**
     * 实例化各种组件
     */
    private void initialization(){
        System.out.println("initialization start");
        progress_circular_movie_article = (ProgressBar) findViewById(R.id.progress_circular_movie_article);
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recyclerView);


        layoutManager = new LinearLayoutManager(MainActivity.this); // Context -> Activity.this
        my_recycler_view.setLayoutManager(layoutManager);

        my_recycler_view.setHasFixedSize(true);

        // adapter
        adapter = new MovieArticleAdapter(MainActivity.this , articleArraylist);
        my_recycler_view.setAdapter(adapter);

        articleViewModel =  ViewModelProviders.of(this).get(ArticleViewModel.class);

        System.out.println("initialization end");

    }

    private void getMovieArticles(){
        System.out.println("getMovieArticles start");
        articleViewModel.getArticleResponseLiveData().observe(this , articleResponse -> {
            if(articleResponse != null){
                progress_circular_movie_article.setVisibility(View.GONE);
                List<Article> articles = articleResponse.getArticles();
                articleArraylist.addAll(articles);
                adapter.notifyDataSetChanged();
            }
        });
        Log.d(TAG , "getMovieArticles End");
    }














}
