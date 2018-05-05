package com.alwaysbaked.techbulletin.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alwaysbaked.techbulletin.R;
import com.alwaysbaked.techbulletin.model.Article;
import com.alwaysbaked.techbulletin.presenter.ArticlePresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ArticleView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArticlePresenter articlePresenter = new ArticlePresenter(this);
        articlePresenter.getArticles();
    }

    @Override
    public void articlesReady(List<Article> articles) {

        for (Article article : articles ){
            Log.i("Article", article.getTitle() == null ?"something is wrong" : article.getTitle());
        }

    }
}
