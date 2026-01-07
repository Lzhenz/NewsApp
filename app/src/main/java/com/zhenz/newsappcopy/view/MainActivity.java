package com.zhenz.newsappcopy.view;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.zhenz.newsappcopy.R;

import java.util.ArrayList;

// 目前对于xml的视图代码，AppCompatActivity依旧是最优解
public class MainActivity extends AppCompatActivity {
    // 定义xml中的类型，一共是三个
    private ProgressBar progress_circular_movie_article;
    private RecyclerView my_recycler_view;
    private ConstraintLayout layoutManager;

    // 定义adapter
    // todo:after define
    // private MovieArticleAdapter adapter;

    // 定义当前activity的使用的数据类型
    // todo:after define
    // private ArrayList<Article> articleArraylist =  new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activate_main);
    }




















}
