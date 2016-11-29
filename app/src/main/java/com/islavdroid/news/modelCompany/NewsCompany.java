package com.islavdroid.news.modelCompany;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class NewsCompany {
    @SerializedName("sources")
    List<Source>sourceList;

    public List<Source> getSourceList() {
        return sourceList;
    }
}
