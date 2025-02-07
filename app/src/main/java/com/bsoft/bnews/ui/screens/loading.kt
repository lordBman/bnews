package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview
import com.bsoft.bnews.viewmodels.NewsDataViewModel

@Composable
fun LoadingScreen(newsDataViewModel: NewsDataViewModel = hiltViewModel<NewsDataViewModel>()){
    Surface(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Surface(modifier = Modifier.weight(weight = 1f)) {

            }
            Text("Loading...")
        }
    }
}

@MobilePreview
@Composable
fun LoadingScreenPreview(){
    BNewsTheme {
        LoadingScreen()
    }
}