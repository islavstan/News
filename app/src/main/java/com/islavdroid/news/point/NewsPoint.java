package com.islavdroid.news.point;

import com.islavdroid.news.modelCompany.NewsCompany;
import com.islavdroid.news.modelNews.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface NewsPoint {
    @GET("v1/articles")
    Call<News> getNews(@Query("source")String source, @Query("apiKey") String apiKey);
}
