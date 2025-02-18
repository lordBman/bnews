package com.bsoft.bnews.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImagePainter
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.compose.rememberConstraintsSizeResolver
import coil3.request.ImageRequest
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview

@Composable
fun NetworkImage(modifier: Modifier = Modifier, imageUrl: String?){
    val sizeResolver = rememberConstraintsSizeResolver()
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalPlatformContext.current).data(imageUrl).build(),
    )

    val painterState by painter.state.collectAsState()
    val bg = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)

    when(painterState){
        is AsyncImagePainter.State.Loading -> {
            // Show a light grey background while loading
            Box(modifier = modifier.background(bg), contentAlignment = Alignment.Center) {
                Text("Loading...", color = MaterialTheme.colorScheme.onSurface) // Optional: Add a loading indicator or text
            }
        }
        is AsyncImagePainter.State.Success -> {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = modifier.then(sizeResolver),
            )
        }
        else -> {
            Box(modifier = modifier.background(bg), contentAlignment = Alignment.Center) {}
        }
    }
}

@MobilePreview
@Composable
private fun NetworkImagePreview(){
    BNewsTheme {
        NetworkImage(modifier = Modifier.size(width = 300.dp, height = 300.dp), imageUrl = "https://i0.wp.com/newtelegraphng.com/wp-content/uploads/2025/02/images-29-2.jpeg?fit=650%2C350&ssl=1")
    }
}