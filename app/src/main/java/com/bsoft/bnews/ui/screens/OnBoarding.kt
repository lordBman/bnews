package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bsoft.bnews.R
import com.bsoft.bnews.ui.LocalRootNavController
import com.bsoft.bnews.ui.components.Carousel
import com.bsoft.bnews.ui.components.SlideDatum
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview

val data = listOf(
    SlideDatum(title = "First Slide", animation = R.raw.animation_three, description = "I am the first Slide"),
    SlideDatum(title = "Second Slide", animation = R.raw.animation_four, description = "I am the second Slide"),
    SlideDatum(title = "Third Slide", animation = R.raw.animation_five, description = "I am the third Slide"),
    SlideDatum(title = "Forth Slide", animation = R.raw.animation_six, description = "I am the forth Slide"),
    SlideDatum(title = "Fifth Slide", animation = R.raw.animation_sevent, description = "I am the fifth Slide")
)

@Composable
fun OnBoardingScreen(){
    //val navController = LocalRootNavController.current
    var index by remember {
        mutableIntStateOf(0)
    }

    Surface(modifier = Modifier.fillMaxSize()){
        Column {
            Row(modifier = Modifier.fillMaxWidth().padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Page")
                Text("${index + 1}/${data.size}")
            }
            Carousel(modifier = Modifier.weight(1f), data = data, home = {  } ){
                index = it
            }
        }
    }
}

@MobilePreview
@Composable
fun OnBoardingScreenPreview(){
    BNewsTheme {
        OnBoardingScreen()
    }
}