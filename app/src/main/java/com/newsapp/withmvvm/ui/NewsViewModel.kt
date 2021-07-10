package com.newsapp.withmvvm.ui

import androidx.lifecycle.ViewModel
import com.newsapp.withmvvm.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository,
    ) : ViewModel() {
}