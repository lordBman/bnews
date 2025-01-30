package com.bsoft.news_repository

data class Article(
    val article_id: String,
    val category: List<String>,
    val country: List<String>,
    val description: String,
    val image_url: String?,
    val keywords: List<String>?,
    val language: String,
    val link: String,
    val pubDate: String,
    val pubDateTZ: String,
    val source_icon: String,
    val source_id: String,
    val source_name: String,
    val source_priority: Int,
    val source_url: String,
    val title: String
)

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val results: List<Article>,
    val nextPage: String
)