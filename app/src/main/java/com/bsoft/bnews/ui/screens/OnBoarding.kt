package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bsoft.bnews.ui.LocalRootNavController

@Composable
fun OnBoardingScreen(){
    val navController = LocalRootNavController.current

    Surface(modifier = Modifier.fillMaxSize()){
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text("OnBoarding Screen")
        }
    }
}