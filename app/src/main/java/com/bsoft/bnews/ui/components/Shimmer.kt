package com.bsoft.bnews.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberShimmerBrush(): Brush {
    // Infinite transition for the shimmer animation
    val infiniteTransition = rememberInfiniteTransition()

    // Animate the translation value for the shimmer effect
    val translateAnim by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            RepeatMode.Restart
        )
    )

    // Define the shimmer color shades
    val shimmerColorShades = listOf(
        MaterialTheme.colorScheme.surfaceContainerHigh,
        MaterialTheme.colorScheme.surfaceContainerHigh.copy(0.2f),
        MaterialTheme.colorScheme.surfaceContainerHigh
    )

    // Create a linear gradient brush for the shimmer effect
    return Brush.linearGradient(
        colors = shimmerColorShades,
        start = Offset(translateAnim - 500, translateAnim - 500),
        end = Offset(translateAnim, translateAnim)
    )
}

@Composable
fun Shimmer(modifier: Modifier = Modifier, brush: Brush = rememberShimmerBrush(), borderRadius: Dp = 20.dp, width: Dp? = null, height: Dp? = null){
    val shape = RoundedCornerShape(size = borderRadius)
    var finalModifier = modifier

    finalModifier = if(width != null){
        finalModifier.width(width)
    }else{
        finalModifier.fillMaxWidth()
    }

    finalModifier = if(height != null){
        finalModifier.height(height)
    }else{
        finalModifier.fillMaxHeight()
    }

    Spacer(modifier = finalModifier.background(brush = brush, shape = shape))
}