package com.example.myapplication;

import com.example.myapplication.database.entity.News;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseWrapper {
    String status;
    int totalResults;
    @SerializedName("articles")
    List<News> newsList;
}
