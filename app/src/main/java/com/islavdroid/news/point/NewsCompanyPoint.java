package com.islavdroid.news.point;

import com.islavdroid.news.modelCompany.NewsCompany;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NewsCompanyPoint {
    @GET("v1/sources")
    Call<NewsCompany> getCompany();
}

