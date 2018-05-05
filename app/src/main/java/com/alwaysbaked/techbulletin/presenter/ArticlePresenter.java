package com.alwaysbaked.techbulletin.presenter;

import com.alwaysbaked.techbulletin.model.Article;
import com.alwaysbaked.techbulletin.model.Data;
import com.alwaysbaked.techbulletin.rest.ArticleService;
import com.alwaysbaked.techbulletin.view.ArticleView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlePresenter {

    private static final String SOURCE = "hacker-news";
    private static final String API_KEY = "84a072f692a848689b11ff35496cddcc";


    private ArticleService articleService;
    private ArticleView articleView;

    public ArticlePresenter(ArticleView articleView) {
        this.articleView = articleView;

        if (this.articleService == null){
            this.articleService = new ArticleService();
        }
    }

    public void getArticles(){
        articleService
                .getAPI()
                .getTopHeadlines(SOURCE, API_KEY)
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Data data = response.body();

                        if (data != null && data.getArticles() != null){
                            List<Article> result = data.getArticles();
                            articleView.articlesReady(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
