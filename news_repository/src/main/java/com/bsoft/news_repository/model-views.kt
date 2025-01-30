package com.bsoft.news_repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NewsDataViewModel : ViewModel() {
    private fun getLatestNews() {
        viewModelScope.launch {
            val listResult = NewsDataApiService.NewsDataApi.api.getNews();
        }
    }
}