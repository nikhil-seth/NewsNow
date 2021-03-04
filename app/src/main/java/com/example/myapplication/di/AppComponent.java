package com.example.myapplication.di;

import com.example.myapplication.apicall.NewsAPI;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ApiUtilModule.class,AppModule.class})
public interface AppComponent {
    public NewsAPI getNewsAPIInterface();
    // void inject(MainActivity activity);
}
