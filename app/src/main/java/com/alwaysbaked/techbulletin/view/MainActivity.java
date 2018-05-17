package com.alwaysbaked.techbulletin.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alwaysbaked.techbulletin.R;
import com.alwaysbaked.techbulletin.adapter.ArticleAdapter;
import com.alwaysbaked.techbulletin.model.Article;
import com.alwaysbaked.techbulletin.presenter.ArticleContract;
import com.alwaysbaked.techbulletin.presenter.ArticlePresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ArticleContract.View {

    private static final String TOOLBAR_TITLE = "Top Stories";

    private ArticlePresenter presenter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArticleAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new ArticlePresenter(this);
        presenter.getArticle();
        recyclerView = findViewById(R.id.articleRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(TOOLBAR_TITLE);

    }


    @Override
    public void onGetResultSuccess(List<Article> articles) {
        adapter = new ArticleAdapter(getApplicationContext(), articles, presenter);
        recyclerView.setAdapter(adapter);
        for (Article article : articles ){
            Log.i("Article", article.getTitle() == null ?"something is wrong" : article.getTitle());
        }
    }

    @Override
    public void onGetResultFailure(String message) {

    }

    @Override
    public void startArticleActivity(Article article) {
        Intent intent = new Intent(getApplicationContext(), ArticleActivity.class);
        intent.putExtra("Article Headline", article.getTitle());
        intent.putExtra("Article Description", article.getDescription());
        intent.putExtra("Article Image URL", article.getUrlToImage());
        intent.putExtra("Article URL", article.getUrl());
        startActivity(intent);
    }
}
