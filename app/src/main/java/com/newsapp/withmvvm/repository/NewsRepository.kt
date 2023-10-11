package com.newsapp.withmvvm.repository

import com.newsapp.withmvvm.api.RetrofitInstance
import com.newsapp.withmvvm.db.ArticleDatabase
import com.newsapp.withmvvm.models.Article

class NewsRepository(
    private val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticle()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

    fun checkArticleExist(url: String) = db.getArticleDao().articledInSaved(url)

}