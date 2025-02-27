package com.bsoft.bnews.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.bsoft.bnews.R
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview

data class SlideDatum(
    val title: String,
    val description: String,
    val animation: Int)

@Composable
fun SliderItem(datum: SlideDatum, modifier: Modifier = Modifier){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(datum.animation))

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier = Modifier.height(320.dp), contentAlignment = Alignment.Center) {
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                contentScale = ContentScale.Fit,
                maintainOriginalImageBounds = false,
                outlineMasksAndMattes = false,
                clipToCompositionBounds = false
                //clipSpec = LottieClipSpec.Progress(0.5f, 0.75f),
            )
        }
        Text(modifier = Modifier.padding(horizontal = 20.dp), text =  datum.title, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(modifier = Modifier.padding(horizontal = 20.dp), text = datum.description, fontWeight = FontWeight.ExtraLight, fontSize = 14.sp)
    }
}


@MobilePreview
@Composable
fun PreviewSlideItem(){
    val datum = SlideDatum(title = "First Slide", animation = R.raw.animation_six, description = "I am the first Slide")
    BNewsTheme {
        Surface {
            SliderItem(datum)
        }
    }
}