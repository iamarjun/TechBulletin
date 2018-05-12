package com.alwaysbaked.techbulletin.rest;

import android.support.annotation.NonNull;

import com.alwaysbaked.techbulletin.model.Article;
import com.alwaysbaked.techbulletin.model.Data;
import com.alwaysbaked.techbulletin.presenter.ArticleContract;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleData implements ArticleContract.GetAPIData {
    private static final String SOURCE = "hacker-news";
    private static final String API_KEY = "84a072f692a848689b11ff35496cddcc";

    private ArticleContract.onGetDataListener dataListener;
    private ArticleService articleService;

    public ArticleData(ArticleContract.onGetDataListener dataListener) {
        this.dataListener = dataListener;
        this.articleService = new ArticleService();
    }

    @Override
    public void initiateRetrofitCall() {
        articleService
                .getAPI()
                .getTopHeadlines(SOURCE, API_KEY)
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                        Data data = response.body();

                        if (data != null && data.getArticles() != null){
                            List<Article> result = data.getArticles();
                            dataListener.onSuccess(result);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            dataListener.onFailure(e.getMessage());
                        }
                    }
                });

    }
}
