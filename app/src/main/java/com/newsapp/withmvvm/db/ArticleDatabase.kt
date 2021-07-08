package com.newsapp.withmvvm.db

import android.content.Context
import androidx.room.*
import com.newsapp.withmvvm.models.Article

@Database(
    entities = [Article::class],
    version = 1,

)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile   // That means other thread can see  when thread change this instance
        private var instance: ArticleDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "NewZApp.db"
            ).build()
    }

}