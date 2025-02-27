package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bsoft.bnews.ui.components.ArticleFullView
import com.bsoft.bnews.viewmodels.NewsDataViewModel
import com.bsoft.news_repository.Article

@Composable
fun ArticleScreen(category: String, id: String, newsDataViewModel: NewsDataViewModel = hiltViewModel()){
    val newsState by newsDataViewModel.state.collectAsState()

    fun find(category: String, id: String): Article?{
        val articles = newsState.categories[category]?.response?.results as List<Article>;
        for(it in articles) {
            if(it.article_id == id){
                return  it
            }
        }
        return null;
    }

    val article = find(category, id) as Article

    Scaffold {
        Surface(modifier = Modifier.padding(it)){
            ArticleFullView(article = article)
        }
    }
}