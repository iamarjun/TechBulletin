package com.alwaysbaked.techbulletin.rest;
import com.alwaysbaked.techbulletin.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleAPI {
    @GET("top-headlines")
    Call<Data> getTopHeadlines(@Query("sources") String sources, @Query("apiKey") String apiKey);
}
