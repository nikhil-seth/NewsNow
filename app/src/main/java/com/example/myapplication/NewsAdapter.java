package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private List<NewsItem> newsItemList;

    public NewsAdapter(List<NewsItem> newsItemList){
        this.newsItemList = newsItemList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newslayout, parent, false);
        return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.setContent(newsItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle,mAuthor,mDescription;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.ntitle);
            mAuthor = itemView.findViewById(R.id.author);
            mDescription = itemView.findViewById(R.id.description);
        }
        void setContent(@NonNull NewsItem newsItem){
            mTitle.setText(newsItem.getTitle());
            mAuthor.setText(newsItem.getAuthor());
            mDescription.setText(newsItem.getDescription());

        }
    }
}
