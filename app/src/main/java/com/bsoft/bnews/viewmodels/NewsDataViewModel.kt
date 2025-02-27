package com.bsoft.bnews.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoft.news_repository.ArticleResponse
import com.bsoft.news_repository.NewsDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArticleResponseState(
    val response: ArticleResponse,
    val loading: Boolean = false,
    val isError: Boolean = false,
    val message: String = "",
    val error: Throwable? = null,
)

data class NewsDataState(
    val categories: Map<String, ArticleResponseState> = mapOf(),
    val loading: Boolean = true,
    val isError: Boolean = false,
    val message: String = "",
    val error: Throwable? = null,
)


@HiltViewModel
class NewsDataViewModel @Inject constructor(private val repository: NewsDataRepository) : ViewModel(){
    private val _categories = listOf("all", "sports", "technology", "entertainment", "politics", "crime")

    private val _mutableState = MutableStateFlow(NewsDataState())
    val state = _mutableState.asStateFlow()

    init {
        viewModelScope.launch {
            _mutableState.update {
                it.copy(loading = true, isError = false, message = "initializing, please wait...")
            }
            load()
        }
    }

    private suspend fun load(){
        val init = mutableMapOf<String, ArticleResponseState>()
        try{
            init["latest"] = ArticleResponseState(response = repository.latest())

            for (category in _categories){
                val response = if(category == "all"){
                    repository.categories(categories = _categories.subList(1, _categories.size) )
                }else{
                    repository.category(category = category)
                }
                init[category] = ArticleResponseState(response = response);
            }
        }catch (error: Throwable){
            Log.e("news article fetching error", error.message ?: error.toString())
            _mutableState.update { it.copy(error = error, isError = true, message = "error fetching news, check connection") }
        }finally {
            _mutableState.update { it.copy(loading = false, categories = init) }
        }
    }

    fun reload(){
        viewModelScope.launch {
            _mutableState.update {
                it.copy(loading = true, isError = false, message = "reloading, please wait...")
            }
            load()
        }
    }

    fun loadMore(category: String){
        if(_mutableState.value.categories.containsKey(category)){
            val articleState = _mutableState.value.categories[category] as ArticleResponseState
            if(articleState.response.nextPage != null){
                _mutableState.update {
                    val init = _mutableState.value.categories.toMutableMap()
                    init.replace(category, articleState.copy(loading = true, isError = false, error = null))
                    it.copy(categories = init)
                }

                val init = _mutableState.value.categories.toMutableMap()
                try {
                    viewModelScope.launch {
                        val response = when (category) {
                            "all" -> {
                                repository.categories(categories = _categories.subList(1, _categories.size), page = articleState.response.nextPage)
                            }
                            "latest" -> {
                                repository.latest(page = articleState.response.nextPage)
                            }
                            else -> {
                                repository.category(category = category, page = articleState.response.nextPage)
                            }
                        }
                        val mutableList = articleState.response.results.toMutableList()
                        mutableList.addAll(response.results)

                        init.replace(category, ArticleResponseState(response = response.copy(results = mutableList)))
                    }
                }catch (error: Throwable){
                    Log.e("news article fetching error", error.message ?: error.toString())

                    init.replace(category, articleState.copy(loading = false, error = error, isError = true, message = "error fetching news, check connection"))
                }finally {
                    _mutableState.update { it.copy(categories = init) }
                }
            }
        }
    }
}