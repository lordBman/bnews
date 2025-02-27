package com.bsoft.bnews.ui.components

import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bsoft.bnews.R
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview
import kotlinx.coroutines.launch

@Composable
fun Carousel(modifier: Modifier = Modifier, data: List<SlideDatum>, home: (()-> Unit)? = null, indexChange: (index: Int)-> Unit){
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Snap behavior to show one item at a time
    val snapBehavior = rememberSnapFlingBehavior(lazyListState = listState)

    // Current visible item index
    val currentIndex by remember { derivedStateOf { listState.firstVisibleItemIndex } }
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex }.collect {
            indexChange(it)
        }
    }

    fun to(index: Int){
        coroutineScope.launch {
            listState.animateScrollToItem(index)
        }
    }

    fun next(){
        if(currentIndex == data.lastIndex){
            home?.invoke()
        }else{
            coroutineScope.launch {
                listState.animateScrollToItem(currentIndex + 1)
            }
        }
    }

    val nextText = if (currentIndex == data.lastIndex) { "Get Started" } else { "Next" }

    Column(modifier = modifier){
        Box(contentAlignment = Alignment.Center, modifier = Modifier.weight(1f)) {
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                LazyRow(state = listState, flingBehavior = snapBehavior, modifier = Modifier.fillMaxWidth()) {
                    items(data.size) { index ->
                        SliderItem(data[index], modifier = Modifier.width(screenWidth))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Indicators(current = currentIndex, size = data.size) { to(it) }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth().padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = { home?.invoke() }) {
                Text("Skip", style = TextStyle(fontWeight = FontWeight.Thin))
            }
            Button(onClick = { next() }) {
                Text(text = nextText, style = TextStyle(fontWeight = FontWeight.Thin))
            }
        }
    }
}

@MobilePreview
@Composable
fun CarouselPreview(){
    val data = listOf(
        SlideDatum(title = "First Slide", animation = R.raw.animation_three, description = "I am the first Slide"),
        SlideDatum(title = "Second Slide", animation = R.raw.animation_four, description = "I am the second Slide"),
        SlideDatum(title = "Third Slide", animation = R.raw.animation_five, description = "I am the third Slide"),
        SlideDatum(title = "Forth Slide", animation = R.raw.animation_six, description = "I am the forth Slide"),
        SlideDatum(title = "Fifth Slide", animation = R.raw.animation_sevent, description = "I am the fifth Slide")
    )
    BNewsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Carousel(data = data){}
        }
    }
}