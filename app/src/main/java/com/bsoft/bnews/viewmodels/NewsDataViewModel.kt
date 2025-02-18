package com.bsoft.bnews.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoft.news_repository.ArticleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import com.bsoft.news_repository.NewsDataRepository;
import com.bsoft.news_repository.SampleArticleResponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

data class NewsDataState(
    val categories: Map<String, ArticleResponse> = mapOf(),
    val loading: Boolean = true,
    val isError: Boolean = false,
    val message: String = "",
    val error: Throwable? = null,
)

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsDataRepository(): NewsDataRepository {
        return NewsDataRepository()
    }
}

@HiltViewModel
class NewsDataViewModel @Inject constructor(private val repository: NewsDataRepository) : ViewModel(){
    private val _categories = listOf("all", "sports", "technology", "entertainment", "politics", "crime")
    val categories = _categories

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
        try{
            val init = mutableMapOf<String, ArticleResponse>()
            init["latest"] = repository.latest()

            for (category in _categories){
                val response = if(category == "all"){
                    repository.categories(categories = _categories.subList(1, _categories.size) )
                }else{
                    repository.categories(categories = listOf(category))
                }
                init[category] = response;
            }
            _mutableState.update { it.copy(categories = init) }
        }catch (error: Throwable){
            Log.e("news article fetching error", error.message ?: error.toString())
            _mutableState.update { it.copy(error = error, isError = true, message = "error fetching news, check connection") }
        }finally {
            _mutableState.update { it.copy(loading = false) }
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
}