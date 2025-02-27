package com.bsoft.bnews.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoft.news_repository.Article
import com.bsoft.news_repository.NewsDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArticleViewState(
    val article: Article? = null,
    val loading: Boolean = true,
    val isError: Boolean = false,
    val message: String = "",
    val error: Throwable? = null,
)

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: NewsDataRepository) : ViewModel(){
    private val _mutableState = MutableStateFlow(ArticleViewState())
    val state = _mutableState.asStateFlow()

    private suspend fun fetch(id: String){
        _mutableState.update { it.copy(loading = true, error = null, isError = false, message = "reloading, please wait...") }
        try{
            val response = repository.get(id)

            _mutableState.update { it.copy(article = response) }
        }catch (error: Throwable){
            Log.e("news article fetching error", error.message ?: error.toString())
            _mutableState.update { it.copy(error = error, isError = true, message = "error fetching news, check connection") }
        }finally {
            _mutableState.update { it.copy(loading = false) }
        }
    }

    fun load(id: String){
        viewModelScope.launch {
            fetch(id = id)
        }
    }
}