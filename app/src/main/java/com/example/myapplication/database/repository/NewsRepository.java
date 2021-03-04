package com.example.myapplication.database.repository;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.Category;
import com.example.myapplication.database.NewsDatabase;
import com.example.myapplication.database.dao.NewsDao;
import com.example.myapplication.database.entity.News;

import java.util.List;

public class NewsRepository {
    private NewsDao newsDao;

    public NewsRepository(Application application) {
        NewsDatabase db = NewsDatabase.getDatabase(application);
        this.newsDao = db.newsDao();
    }
    public void insertData(List<News> newsList, Category category){
        NewsDatabase.databaseWriteExecutor.execute(()->{
            for(News news:newsList){
                news.setCategory(category.getName());
                newsDao.insert(news);
            }
        });
    }
    public List<News> fetchData(Context context, Category category, boolean hardLoad){
        if(!hardLoad) {
            if (!checkData(category))
                hardLoad = true;
        }
        if(hardLoad) {
            deleteCategoryNews(category);
            //API call.
        }
        return getCategoryNews(category);
    }
    public void deleteCategoryNews(Category category){
        NewsDatabase.databaseWriteExecutor.execute(()->{
            newsDao.deleteAllFromCategory(category.getName());
        });
    }
    public List<News> getCategoryNews(Category category) {
        return newsDao.getCategoryNews(category.getName());
    }
    public boolean checkData(Category category){
        Integer i =newsDao.checkData(category.getName());
        if(i>0)
            return true;
        return false;
    }

}
