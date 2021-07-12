package com.newsapp.withmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.newsapp.withmvvm.R
import com.newsapp.withmvvm.api.RetrofitInstance
import com.newsapp.withmvvm.db.ArticleDatabase
import com.newsapp.withmvvm.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val repository = NewsRepository(ArticleDatabase.invoke(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(repository)

        newsViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment

        val navController = navHostFragment.navController

        bottomNavigationView.setupWithNavController(navController)
    }
}