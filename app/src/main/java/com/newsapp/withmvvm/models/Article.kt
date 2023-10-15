package com.newsapp.withmvvm.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Parcelize helps the data class to be easily passed to NavArgs, and it automatically handles everything
 * This is the new way of passing arguments to NavArgs
 */
@Parcelize
@Entity(tableName = "Articles")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Parcelable