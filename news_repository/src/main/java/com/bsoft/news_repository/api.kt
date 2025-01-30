package com.bsoft.news_repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://newsdata.io/api/1";

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()




interface NewsDataApiService {
    @GET("/news")
    suspend fun latest(
        @Query("apikey") apikey:String="pub_66705f2098a380da6cdb6fd90e81062f3b45f",
        @Query("country")country: String = "ng",
        @Query("page")page: String? = "1"
         ): ArticleResponse

    object NewsDataApi {
        val api : NewsDataApiService by lazy {
            retrofit.create(NewsDataApiService::class.java)
        }
    }

}