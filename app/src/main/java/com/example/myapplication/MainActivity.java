package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Void> {
    private Retrofit retrofit;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoaderManager l =LoaderManager.getInstance(this);
        List<NewsItem> li = fn();
        Log.d("Size",Integer.toString(li.size()));
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter adapter = new NewsAdapter(li);
        recyclerView.setAdapter(adapter);
    }


    @NonNull
    @Override
    public Loader<Void> onCreateLoader(int id, @Nullable Bundle args) {
        Category cat = new Category(true,"business");
        return new ApiCallTask(this, cat);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Void> loader, Void data) {
        Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLoaderReset(@NonNull Loader<Void> loader) {

    }

    public void btnclk(View view) {
        Log.d("Test","BTN click");
        Bundle queryBundle = new Bundle();
        LoaderManager.getInstance(this).restartLoader(0, queryBundle, this);
    }
    List<NewsItem> fn(){
        List<NewsItem> ni = new ArrayList<>();
        for(int i=0;i<10;i+=1) {
            NewsItem nx = new NewsItem();
            nx.setAuthor("A" + Integer.toString(i));
            nx.setTitle("B" + Integer.toString(i));
            nx.setDescription("C" + Integer.toString(i));
            ni.add(nx);
        }
        return ni;
    }
}