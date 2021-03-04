package com.example.myapplication.database.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.myapplication.database.entity.News;

import java.util.List;

import static com.example.myapplication.constants.Constants.NEWS_TABLE;

@Dao
public interface NewsDao extends BaseDao<News> {
    @Query("SELECT * FROM " + NEWS_TABLE + " WHERE category = :category")
    List<News> getCategoryNews(String category);

    @Query("DELETE FROM " + NEWS_TABLE + " WHERE category = :category")
    void deleteAllFromCategory(String category);

    @Query("DELETE FROM " + NEWS_TABLE)
    void deleteAll();
    @Query("SELECT COUNT(*) FROM " + NEWS_TABLE + " WHERE category = :category")
    Integer checkData(String category);
}