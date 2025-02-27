package com.bsoft.bnews.ui.shimmers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bsoft.bnews.ui.components.Shimmer
import com.bsoft.bnews.ui.components.rememberShimmerBrush
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview

@Composable
fun SearchShimmers() {
    val shimmerBrush = rememberShimmerBrush()
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(state = scrollState, enabled = false).padding(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)){
        repeat(12){
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)){
                Shimmer(width = 100.dp, height = 100.dp, brush = shimmerBrush)
                Column(modifier = Modifier.height(100.dp), verticalArrangement = Arrangement.SpaceBetween){
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
                        Shimmer(height = 20.dp, borderRadius = 10.dp, brush = shimmerBrush)
                        Shimmer(height = 20.dp, width = 160.dp, borderRadius = 10.dp, brush = shimmerBrush)
                        Shimmer(height = 20.dp, width = 100.dp, borderRadius = 10.dp, brush = shimmerBrush)
                    }
                    Shimmer(height = 10.dp, borderRadius = 10.dp, brush = shimmerBrush)
                }
            }
        }
    }
}

@MobilePreview
@Composable
fun SearchShimmersPreview(){
    BNewsTheme {
        Surface(modifier = Modifier.fillMaxSize()){
            SearchShimmers()
        }
    }
}