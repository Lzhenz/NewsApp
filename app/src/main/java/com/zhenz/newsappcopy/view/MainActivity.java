package com.zhenz.newsappcopy.view;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhenz.newsappcopy.R;
import com.zhenz.newsappcopy.adapter.MovieArticleAdapter;
import com.zhenz.newsappcopy.model.Article;
import com.zhenz.newsappcopy.view_model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

// 目前对于xml的视图代码，AppCompatActivity依旧是最优解
public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    // 定义xml中的类型，一共是三个
    private ProgressBar progress_circular_movie_article;
    private RecyclerView my_recycler_view;
    private Button btn_2Login;
    private LinearLayoutManager layoutManager;

    // 定义adapter
    private MovieArticleAdapter adapter;

    // 定义当前activity的使用的数据类型
    private ArrayList<Article> articleArraylist =  new ArrayList<>();

    // todo:after define
    private ArticleViewModel articleViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activate_main);
        btn_2Login = findViewById(R.id.btn_2login);

        // get init
        initialization();

        // get data
        getMovieArticles();

        // click event
        btn_2Login.setOnClickListener(v->{
            articleViewModel.onDetailButtonClick();
        });

        articleViewModel.getNavigateToDetailEvent().observe(this , event -> {
            // Log.d(TAG , "************" + event.getContentIfNotHandled() + "************");
            Log.d("ACT", "observe event, vm=" + articleViewModel);
            if (event == null) return;;
            if (event.getContentIfNotHandled() != null){
                startActivity(new Intent(this, loginPage.class));
            }else{
                Log.d(TAG, "无法进行跳转～～～～～～～～～～～～～" + event.getContentIfNotHandled());
            }
        });
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

        // articleViewModel =  ViewModelProviders.of(this).get(ArticleViewModel.class);
        articleViewModel = new ViewModelProvider(this).get(ArticleViewModel.class);
        System.out.println("initialization end");

    }

    private void getMovieArticles(){
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
