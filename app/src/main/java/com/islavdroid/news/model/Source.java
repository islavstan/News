package com.islavdroid.news.model;

import com.google.gson.annotations.SerializedName;



public class Source {
    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("url")
    String url;
    @SerializedName("category")
    String category;
    @SerializedName("language")
    String language;
    @SerializedName("urlsToLogos")
    UrlToLogos urlToLogos;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public UrlToLogos getUrlToLogos() {
        return urlToLogos;
    }
}
