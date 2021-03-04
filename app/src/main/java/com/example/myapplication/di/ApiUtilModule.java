package com.example.myapplication.di;

import android.util.Log;

import com.example.myapplication.apicall.NewsAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.myapplication.constants.Constants.BASE_URL;

@Module
public class ApiUtilModule {

    @Provides
    @Singleton
    NewsAPI getNewsAPIInterface(Retrofit retrofit){
        Log.d("IN MOD","Retrofit");
        return retrofit.create(NewsAPI.class);
    }

    @Provides
    @Singleton
    Retrofit getRetrofitObject(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    @Singleton
    OkHttpClient getOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }
}