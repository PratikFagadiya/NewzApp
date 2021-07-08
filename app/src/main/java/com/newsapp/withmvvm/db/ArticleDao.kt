package com.newsapp.withmvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.newsapp.withmvvm.models.Article

@Dao
interface ArticleDao {

    //    FOR UPDATE AND INSERT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM Articles")
    fun getAllArticle(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
    
}