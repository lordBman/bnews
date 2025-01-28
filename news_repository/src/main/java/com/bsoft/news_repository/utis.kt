package com.bsoft.news_repository

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://newsdata.io/api/1";

private val retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).baseUrl(BASE_URL).build()

interface NewsDataApiService {
    @GET("news")
    suspend fun getNews(): String

    object NewsDataApi {
        val retrofitService : NewsDataApiService by lazy {
            retrofit.create(NewsDataApiService::class.java)
        }
    }
}