package com.bsoft.bnews.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoft.bnews.utils.RootRoutes
import com.bsoft.bnews.viewmodels.ArticleResponseState
import com.bsoft.news_repository.ArticleResponse
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeContent(categories: Map<String, ArticleResponseState>, onLoadMore: ((category: String)->Unit)? = null, chosen: (choice: String)->Unit){
    val catKeys = categories.keys.toList()
    var activeCategory by remember {
        mutableStateOf(catKeys.first())
    }

    val listScrollState = rememberScrollState()
    // Trigger "load more" when near the bottom
    LaunchedEffect(listScrollState) {
        snapshotFlow { listScrollState.value }.collectLatest { scrollPosition ->
            val scrollRange = listScrollState.maxValue
            // Load more if the user is within 100 pixels of the bottom
            if (scrollPosition >= scrollRange - 100) {
                onLoadMore?.invoke(activeCategory)
            }
        }
    }

    Column(modifier = Modifier.verticalScroll(state = listScrollState, enabled = true)) {
        Text("Headlines", fontFamily = FontFamily.SansSerif, modifier = Modifier.padding(top = 20.dp, start = 20.dp), color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.76f), fontSize = 22.sp)
        Row (horizontalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.horizontalScroll(state = rememberScrollState(), enabled = true).padding(horizontal = 20.dp, vertical = 10.dp)){
            categories["latest"]?.response?.results?.map {
                ArticleHeadlineView(article = it){ id ->
                    chosen("latest/${id}")
                }
            }
        }
        Categories(labels = catKeys, active = activeCategory, padding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 10.dp)) { activeCategory = it }
        Column(verticalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(horizontal = 20.dp)){
            categories[activeCategory]?.response?.results?.map {
                ArticleView(article = it){ id ->
                    chosen("${activeCategory}/${id}")
                }
            }
            if(categories[activeCategory]?.loading == true){
               Text("Loading more...")
            }
        }
    }
}