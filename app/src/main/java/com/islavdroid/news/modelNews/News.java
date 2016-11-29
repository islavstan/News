package com.islavdroid.news.modelNews;

import com.google.gson.annotations.SerializedName;
import com.islavdroid.news.modelCompany.Source;

import java.util.List;



public class News {
    @SerializedName("articles")
    List<Article> articleList;

    public List<Article> getArticleList() {
        return articleList;
    }
}
