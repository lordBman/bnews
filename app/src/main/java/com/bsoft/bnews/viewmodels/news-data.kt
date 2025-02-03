package com.bsoft.bnews.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import com.bsoft.news_repository.NewsDataRepository;
import kotlinx.coroutines.launch

@HiltViewModel
class NewsDataViewModel : ViewModel(){
    private val repository: NewsDataRepository = NewsDataRepository()

    fun getLatest(){
        viewModelScope.launch {
            val listResult = repository.latest()
        }
    }
}