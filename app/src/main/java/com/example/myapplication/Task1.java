package com.example.myapplication;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class Task1 extends AsyncTaskLoader<String> {
    private Call<String> cseq;
    private Resp service;

    public Task1(@NonNull Context context, Resp service) {
        super(context);
        this.service = service;
    }



    @Nullable
    @Override
    public String loadInBackground() {
        Log.d("Test", "Inside Background");
        Call<java.lang.String> callSync = service.fn("everything","bitcoin","a636c722f5cc4af4ac687dabc2eb5ce2");
        //Call<java.lang.String> callSync = service.fn("top-headlines?"+"country=us&"+"apiKey=");
        Response<String> response;
        String result=null;
        try {
            response = callSync.execute();
            result = response.body();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            return result;
        }
    }
}

