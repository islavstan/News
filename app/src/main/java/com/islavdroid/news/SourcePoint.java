package com.islavdroid.news;

import com.islavdroid.news.model.NewsCompany;
import com.islavdroid.news.model.Source;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface SourcePoint {
    @GET("v1/sources")
    Call<NewsCompany> getCompany();
}

