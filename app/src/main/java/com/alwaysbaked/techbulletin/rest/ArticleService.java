package com.alwaysbaked.techbulletin.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticleService {

    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static Retrofit retrofit = null;

    public ArticleAPI getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ArticleAPI.class);
    }
}
