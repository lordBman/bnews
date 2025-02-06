package com.bsoft.bnews.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoft.news_repository.ArticleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import com.bsoft.news_repository.NewsDataRepository;
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private val repository: NewsDataRepository = NewsDataRepository()

data class NewsDataState(
    val categories: Map<String, ArticleResponse>,
    val loading: Boolean,
    val isError: Boolean,
    val message: String,
    val error: Throwable? = null
)

private val defaultState = NewsDataState(loading = false, isError = false, message = "", categories = mutableMapOf())

@HiltViewModel
class NewsDataViewModel @Inject constructor() : ViewModel(){
    private val _mutableState = MutableStateFlow(defaultState)
    val state = _mutableState.asStateFlow();

    init {
        _mutableState.update {
            it.copy(loading = true, isError = false, message = "initializing, please wait...")
        }
        load()
    }

    private fun load(){
        viewModelScope.launch {
            try{
                val categories = listOf("top", "sports", "politics", "science", "business", "entertainment")
                val init = mutableMapOf<String, ArticleResponse>();
                for (category in categories){
                    val response = repository.category(category = category)

                    init[category] = response;
                }
                _mutableState.update { it.copy(categories = init) }
            }catch (error: Throwable){
                _mutableState.update { it.copy(error = error, isError = false, message = "error fetching news, check connection") }
            }finally {
                _mutableState.update { it.copy(loading = false) }
            }
        }
    }

    fun reload(){
        _mutableState.update {
            it.copy(loading = true, isError = false, message = "reloading, please wait...")
        }
        load()
    }
}