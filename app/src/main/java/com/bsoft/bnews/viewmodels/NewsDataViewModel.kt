package com.bsoft.bnews.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoft.news_repository.ArticleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import com.bsoft.news_repository.NewsDataRepository;
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
    val loading: Boolean = false,
    val isError: Boolean = false,
    val message: String = "",
    val error: Throwable? = null
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
    private val _mutableState = MutableStateFlow(NewsDataState())
    val state = _mutableState.asStateFlow()

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