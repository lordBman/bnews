package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bsoft.bnews.ui.theme.BNewsTheme

@Composable
fun InfoScreen(){
    Surface(modifier = Modifier.fillMaxSize()) {

    }
}

@Composable
@Preview
fun InfoScreenPreview(){
    BNewsTheme {
        InfoScreen()
    }
}