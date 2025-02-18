package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.bsoft.bnews.ui.LocalRootNavController
import com.bsoft.bnews.ui.components.ArticleView
import com.bsoft.bnews.ui.components.SearchInput
import com.bsoft.bnews.ui.icons.ArrowLeft
import com.bsoft.news_repository.SampleArticleResponse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchTopBar(scrollBehavior: TopAppBarScrollBehavior){
    val rootNavController = LocalRootNavController.current

    MediumTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text("Search", fontFamily = FontFamily.SansSerif)
        },
        navigationIcon = {
            IconButton(onClick = { rootNavController.popBackStack() }){
                Icon(imageVector = ArrowLeft, contentDescription = "")
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(){
    var searchText by remember { mutableStateOf("") }

    // TopAppBar state and scroll behavior
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(topAppBarState)

    // Column scroll state
    val scrollState = rememberScrollState()

    // Link the Column scroll state to the TopAppBar state
    val nestedScrollConnection = remember {
        scrollBehavior.nestedScrollConnection
    }

    Scaffold( topBar = { SearchTopBar(scrollBehavior) }, modifier = Modifier.nestedScroll(nestedScrollConnection)){
        Surface(modifier = Modifier.padding(it)){
            Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState, enabled = true).padding(10.dp).nestedScroll(nestedScrollConnection)) {
                SearchInput(value = searchText) { value -> searchText = value }
                Spacer(modifier = Modifier.height(10.dp))
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)){
                    for (i in 0..9){
                        ArticleView(SampleArticleResponse.results[i])
                    }
                }
            }
        }
    }
}