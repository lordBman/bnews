package com.bsoft.bnews.ui.pages

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.bsoft.bnews.ui.LocalRootNavController
import com.bsoft.bnews.ui.components.HomeContent
import com.bsoft.bnews.ui.components.NetworkError
import com.bsoft.bnews.ui.shimmers.HomeShimmers
import com.bsoft.bnews.utils.RootRoutes
import com.bsoft.bnews.viewmodels.NewsDataViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(topAppBarState: TopAppBarState, newsDataViewModel: NewsDataViewModel = hiltViewModel()){
    val newsState by newsDataViewModel.state.collectAsState()

    val rootNavController = LocalRootNavController.current

    if (!newsState.loading && newsState.categories.isNotEmpty()){
        PullToRefreshBox(onRefresh = { newsDataViewModel.reload() }, isRefreshing = false) {
            HomeContent(categories = newsState.categories, onLoadMore = { newsDataViewModel.loadMore(it) }) {
                rootNavController.navigate("${RootRoutes.article}/$it")
            }
        }
    }else if(newsState.loading){
        HomeShimmers()
    }else{
        NetworkError()
    }
}