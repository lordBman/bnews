package com.bsoft.news_repository

class NewsDataRepository{
    suspend fun latest(page: String? = null): ArticleResponse {
        val response = NewsDataApi.api.latest();
        if(response.isSuccessful && response.body() != null){
            return response.body() as ArticleResponse;
        }else{
            throw Error("unable to fetch News articles, please check network connection")
        }
    }

    suspend fun categories(categories: List<String>): ArticleResponse {
        var category = categories.first()
        for (i in 1..categories.lastIndex){
            category += ",${categories[i]}"
        }

        val response = NewsDataApi.api.news(category = category);
        if(response.isSuccessful && response.body() != null){
            return response.body() as ArticleResponse;
        }else{
            throw Error("unable to fetch the next News articles, please check network connection")
        }
    }

    suspend fun category(category: String, page: String? = null): ArticleResponse {
        val response = NewsDataApi.api.news(page = page, category = category);
        if(response.isSuccessful && response.body() != null){
            return response.body() as ArticleResponse;
        }else{
            throw Error("unable to fetch the next News articles, please check network connection")
        }
    }

    suspend fun search(page: String? = null, q: String): ArticleResponse {
        val response = NewsDataApi.api.search(page = page, q = q);
        if(response.isSuccessful && response.body() != null){
            return response.body() as ArticleResponse;
        }else{
            throw Error("unable to fetch the next News articles, please check network connection")
        }
    }
}