package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.myapplication.apicall.NewsAPI;
import com.example.myapplication.database.entity.News;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.myapplication.constants.Constants.API_KEY;
import static com.example.myapplication.constants.Constants.BASE_URL;

public class ApiCallTask extends AsyncTaskLoader<List<News>> {
    private Context context;
    private Category category;
    private String country;
    public NewsAPI newsAPI;
    public ApiCallTask(@NonNull Context context, @NonNull Category category) {
        super(context);
        this.context = context;
        this.category = category;
        this.country = "in";
        newsAPI = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(new OkHttpClient.Builder().build())
                .build().create(NewsAPI.class);

    }
    @Override
    protected void onStartLoading() {
        forceLoad(); // Starts the loadInBackground method
    }
    @Nullable
    @Override
    public List<News> loadInBackground() {
        Call<ResponseWrapper> callSync;
        if(newsAPI==null)
            Log.d("ABX","null");
        else
            Log.d("ABX","not null");

        if(category.isCategory()){
            callSync = newsAPI.getHeadlines(country, category.getName(),API_KEY);
        }
        else{
            callSync = newsAPI.getCustomCategory(country, category.getName(),API_KEY);
        }
        Response<ResponseWrapper> response =null;
        try {
            Log.d("RESPONSE", "START");
            response = callSync.execute();
            Log.d("RESPONSE", response.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if(response !=null){
            ResponseWrapper responseWrapper = response.body();
            return responseWrapper.newsList;

        }

        return null;
    }
}
/*
1- API : 100calls per day.
    CAtegory - Sports,bunsines.
    5 cat. 5apicalls.
    bs
2 - Sabko enqueue -> Data(JSON) -> Obj -> database.
3- Async thread -> execute ->database



 */