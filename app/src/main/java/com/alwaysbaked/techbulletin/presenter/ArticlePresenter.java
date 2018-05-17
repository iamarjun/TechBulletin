package com.alwaysbaked.techbulletin.presenter;

import com.alwaysbaked.techbulletin.model.Article;
import com.alwaysbaked.techbulletin.rest.ArticleData;

import java.util.List;

public class ArticlePresenter implements ArticleContract.Presenter, ArticleContract.onGetDataListener {
    private ArticleContract.View articleView;
    private ArticleData articleData;

    public ArticlePresenter(ArticleContract.View articleView) {
        this.articleView = articleView;
        articleData = new ArticleData(this);
    }

    @Override
    public void getArticle() {
        articleData.initiateRetrofitCall();
    }

    @Override
    public void onArticleClick(Article article) {
        articleView.startArticleActivity(article);
    }

    @Override
    public void onSuccess(List<Article> list) {
        articleView.onGetResultSuccess(list);
    }

    @Override
    public void onFailure(String message) {
        articleView.onGetResultFailure(message);
    }
}
