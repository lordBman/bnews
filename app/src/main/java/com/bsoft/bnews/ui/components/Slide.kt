package com.bsoft.bnews.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
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
        Box(modifier = Modifier.fillMaxWidth().height(300.dp)) {
            LottieAnimation(
                modifier = Modifier.fillMaxWidth(),
                composition = composition,
                iterations = LottieConstants.IterateForever,
                contentScale = ContentScale.FillWidth,
                maintainOriginalImageBounds = false,
                outlineMasksAndMattes = false,
                clipToCompositionBounds = false
                //clipSpec = LottieClipSpec.Progress(0.5f, 0.75f),
            )
        }
        Text(datum.title, fontWeight = FontWeight.ExtraBold, fontSize = TextUnit(30f, type = TextUnitType.Sp))
        Spacer(Modifier.height(8.dp))
        Text(text = datum.description, fontSize = TextUnit(14f, type = TextUnitType.Sp), fontWeight = FontWeight.Bold)
    }
}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Slides(data: List<SlideDatum>, modifier: Modifier = Modifier){
    if(data.isEmpty()){
        throw Error("Sides data cannot be empty")
    }/*else if(index >= data.size){
        throw Error("index: $index specified is out of bounds for SlideData provided")
    }*/

    val config = LocalConfiguration.current

    val carouselState = rememberCarouselState { data.size }

    HorizontalMultiBrowseCarousel(modifier = modifier, state = carouselState, preferredItemWidth = config.screenWidthDp.dp) {
        SliderItem(data[it])
    }
}*/

@MobilePreview
@Composable
fun PreviewSlideItem(){
    val datum = SlideDatum(title = "First Slide", animation = R.raw.animation_three, description = "I am the first Slide")
    BNewsTheme {
        Surface {
            SliderItem(datum)
        }
    }
}