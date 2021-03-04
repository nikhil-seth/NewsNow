package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.di.AppComponent;

public class MyApplication extends Application {
    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
//        appComponent = DaggerApiComponent.builder()
//                .apiModule(new ApiUtilModule())
//                .build();
    }
}
