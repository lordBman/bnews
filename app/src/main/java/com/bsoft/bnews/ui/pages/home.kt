package com.bsoft.bnews.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview
import com.bsoft.bnews.viewmodels.NewsDataViewModel

@Composable
fun HomePage(newsDataViewModel: NewsDataViewModel? = hiltViewModel()){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
            Text("Home Page")
        }
    }
}

@MobilePreview
@Composable
fun HomePagePreview(){
    BNewsTheme {
        HomePage(newsDataViewModel = null)
    }
}