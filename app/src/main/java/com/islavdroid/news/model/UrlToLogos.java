package com.islavdroid.news.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by islav on 29.11.2016.
 */

public class UrlToLogos {
    @SerializedName("small")
    String pictureUrl;

    public String getPictureUrl() {
        return pictureUrl;
    }


}
