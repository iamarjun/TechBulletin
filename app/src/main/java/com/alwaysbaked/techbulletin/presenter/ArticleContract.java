package com.alwaysbaked.techbulletin.presenter;

import com.alwaysbaked.techbulletin.model.Article;

import java.util.List;

public interface ArticleContract {

    interface View{
        void onGetResultSuccess(List<Article> articles);
        void onGetResultFailure(String message);
        void startArticleActivity(Article article);
    }

    interface Presenter{
        void getArticle();
        void onArticleClick(Article article);
    }

    interface GetAPIData{
        void initiateRetrofitCall();
    }

    interface onGetDataListener{
        void onSuccess(List<Article> list);
        void onFailure(String message);
    }
}
