package com.example.myapplication;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Resp extends Serializable {
    @GET("{add}")
    public Call<String> fn(@Path("add") String s, @Query("q") String query,@Query("apiKey") String apiKey);
}
