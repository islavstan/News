package com.islavdroid.news.modelNews;

import com.google.gson.annotations.SerializedName;



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

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getImage() {
        return image;
    }
}
