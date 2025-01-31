package com.bsoft.news_repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/*class NewsDataViewModel : ViewModel() {
    private fun getLatestNews() {
        viewModelScope.launch {
           val listResult = NewsDataApiService.NewsDataApi.api.getNews();
        }
    }
}*/

class NewsDataRepository{
    suspend fun latest(page: String? = null): ArticleResponse {
        val response = NewsDataApiService.NewsDataApi.api.news();
        if(response.isSuccessful){
            return response.body() as ArticleResponse;
        }else{
            throw Error("unable to fetch News articles, please check network connection")
        }
    }

    suspend fun category(category: String, page: String? = null): ArticleResponse {
        val response = NewsDataApiService.NewsDataApi.api.news(page = page, category = category);
        if(response.isSuccessful){
            return response.body() as ArticleResponse;
        }else{
            throw Error("unable to fetch the next News articles, please check network connection")
        }
    }

    suspend fun search(page: String? = null, q: String): ArticleResponse {
        val response = NewsDataApiService.NewsDataApi.api.news(page = page, q = q);
        if(response.isSuccessful){
            return response.body() as ArticleResponse;
        }else{
            throw Error("unable to fetch the next News articles, please check network connection")
        }
    }
}