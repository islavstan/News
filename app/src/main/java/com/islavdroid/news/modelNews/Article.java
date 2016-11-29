package com.islavdroid.news.modelNews;

import com.google.gson.annotations.SerializedName;

/**
 * Created by islav on 29.11.2016.
 */

public class Article {
    @SerializedName("author")
    String author;
    @SerializedName("title")
    String title;
    @SerializedName("description")
    String description;
    @SerializedName("url")
    String url;
    @SerializedName("publishedAt")
    String publishedAt;
    @SerializedName("urlToImage")
    String image;

}
