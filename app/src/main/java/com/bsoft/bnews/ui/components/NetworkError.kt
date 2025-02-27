package com.bsoft.bnews.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.bsoft.bnews.R
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview

@Composable
fun NetworkError(){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.network_error))

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
            LottieAnimation(
                modifier = Modifier.height(200.dp),
                composition = composition,
                iterations = LottieConstants.IterateForever,
                contentScale = ContentScale.FillHeight,
                maintainOriginalImageBounds = false,
                outlineMasksAndMattes = false,
                clipToCompositionBounds = false
                //clipSpec = LottieClipSpec.Progress(0.5f, 0.75f),
            )
            Text(modifier = Modifier.width(200.dp), fontWeight = FontWeight.Thin, fontSize = 18.sp, text = "Please check internet connection", textAlign = TextAlign.Center)
        }
    }
}

@MobilePreview
@Composable
private fun NetworkErrorPreview(){
    BNewsTheme {
        Surface {
            NetworkError()
        }
    }
}