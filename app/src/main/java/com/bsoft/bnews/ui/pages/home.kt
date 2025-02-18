package com.bsoft.bnews.ui.pages

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bsoft.bnews.ui.components.ArticleHeadlineView
import com.bsoft.bnews.ui.components.ArticleView
import com.bsoft.bnews.ui.components.Categories
import com.bsoft.bnews.viewmodels.NewsDataViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(topAppBarState: TopAppBarState, newsDataViewModel: NewsDataViewModel = hiltViewModel()){
    val categories = newsDataViewModel.categories
    val newsState by newsDataViewModel.state.collectAsState()

    var activeCategory by remember {
        mutableStateOf(categories.first())
    }

    if (!newsState.loading && !newsState.isError){
        Column(modifier = Modifier.verticalScroll(state = rememberScrollState(), enabled = true)) {
            Text("Headlines", fontFamily = FontFamily.SansSerif, modifier = Modifier.padding(top = 20.dp, start = 20.dp), color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.76f), fontSize = 24.sp)
            Row (horizontalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.horizontalScroll(state = rememberScrollState(), enabled = true).padding(horizontal = 20.dp, vertical = 10.dp)){
                newsState.categories["latest"]?.results?.map {
                    ArticleHeadlineView(article = it)
                }
            }
            Categories(labels = categories, active = activeCategory, padding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 10.dp)) { activeCategory = it }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(horizontal = 20.dp)){
                newsState.categories[activeCategory]?.results?.map {
                    ArticleView(article = it)
                }
            }
        }
    }else{
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = if(newsState.loading){ newsState.message } else { newsState.error?.message ?: newsState.error.toString() })
        }
    }
}