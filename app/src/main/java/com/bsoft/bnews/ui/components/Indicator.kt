package com.bsoft.bnews.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview

@Composable
private fun Indicator(modifier: Modifier = Modifier, activeWidth: Dp = 50.dp, width: Dp = 10.dp, position: Int, current: Int){
    val finalWidth =  if(position == current){ activeWidth } else { width }

    Surface(
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
        shape = RoundedCornerShape(3.dp),
        modifier = modifier.size(width = finalWidth, height = 6.dp)){}
}

@Composable
fun Indicators(current: Int, size: Int, clicked: (index: Int) -> Unit){
    Row(horizontalArrangement = Arrangement.Center) {
        val count = size * 2 - 1

        (1..count).map {
            if(it % 2 == 0){
                Spacer(modifier = Modifier.width(10.dp))
            }else{
                Indicator(position = it / 2, current = current, modifier = Modifier.clickable {
                    clicked(it / 2)
                })
            }
        }
    }
}

@MobilePreview
@Composable
fun IndicatorsPreview(){
    BNewsTheme {
        Surface(modifier = Modifier.fillMaxSize()){
            Box (contentAlignment = Alignment.Center){
                Indicators(current = 0, size = 4, clicked = {})
            }
        }
    }
}