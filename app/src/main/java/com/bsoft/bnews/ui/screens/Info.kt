package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview

@Composable
fun InfoScreen(){
    Surface(modifier = Modifier.fillMaxSize()) {

    }
}

@MobilePreview
@Composable
fun InfoScreenPreview(){
    BNewsTheme {
        InfoScreen()
    }
}