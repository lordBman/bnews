package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bsoft.bnews.R
import com.bsoft.bnews.ui.LocalRootNavController
import com.bsoft.bnews.ui.components.Carousel
import com.bsoft.bnews.ui.components.SlideDatum

@Composable
fun OnBoardingScreen(){
    val navController = LocalRootNavController.current

    val data = listOf(
        SlideDatum(title = "First Slide", animation = R.raw.animation_three, description = "I am the first Slide"),
        SlideDatum(title = "Second Slide", animation = R.raw.animation_four, description = "I am the second Slide"),
        SlideDatum(title = "Third Slide", animation = R.raw.animation_five, description = "I am the third Slide"),
        SlideDatum(title = "Forth Slide", animation = R.raw.animation_six, description = "I am the forth Slide"),
        SlideDatum(title = "Fifth Slide", animation = R.raw.animation_sevent, description = "I am the fifth Slide")
    )

    Surface(modifier = Modifier.fillMaxSize()){
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Carousel(data){

            }
        }
    }
}