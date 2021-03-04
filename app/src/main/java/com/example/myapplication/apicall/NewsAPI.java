package com.example.myapplication.apicall;

import com.example.myapplication.ResponseWrapper;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI extends Serializable {
    /*
    All Code related to API calls which need to be made will be put-up here.
    */
    @GET("/v2/top-headlines")
    Call<ResponseWrapper> getHeadlines(@Query("country") String country,
                                       @Query("category") String category,
                                       @Query("apiKey") String apiKey);
    // To get top headlines for predefined categories.
    @GET("/v2/top-headlines")
    Call<ResponseWrapper> getCustomCategory(@Query("country") String country, @Query("q") String category, @Query("apiKey") String apiKey);
    // To get custom headlines based on query.
}
