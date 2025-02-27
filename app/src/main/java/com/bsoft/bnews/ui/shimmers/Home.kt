package com.bsoft.bnews.ui.shimmers

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
fun HomeShimmers(){
    val shimmerBrush = rememberShimmerBrush()

    Column(modifier = Modifier.verticalScroll(enabled = false, state = rememberScrollState()).padding(top = 20.dp, start = 20.dp)){
        Shimmer(brush = shimmerBrush, borderRadius = 10.dp, width = 140.dp, height = 30.dp)
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.horizontalScroll(enabled = false, state = rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Shimmer(width = 300.dp, height = 240.dp, brush = shimmerBrush)
            Shimmer(width = 300.dp, height = 240.dp, brush = shimmerBrush)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.horizontalScroll(enabled = false, state = rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(10.dp)){
            repeat(4) {
                Shimmer(width = 100.dp, height = 40.dp, borderRadius = 10.dp, brush = shimmerBrush)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier.padding(end = 20.dp), verticalArrangement = Arrangement.spacedBy(10.dp)){
            repeat(6){
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
}

@MobilePreview
@Composable
private fun HomeShimmersPreview(){
    BNewsTheme {
        Surface(modifier = Modifier.fillMaxSize()){
            HomeShimmers()
        }
    }
}