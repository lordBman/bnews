package com.bsoft.bnews.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoft.bnews.ui.icons.AlarmClock
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview
import com.bsoft.bnews.utils.Utility
import com.bsoft.bnews.utils.duration
import com.bsoft.bnews.utils.localize
import com.bsoft.news_repository.Article
import com.bsoft.news_repository.SampleArticleResponse

@Composable
fun ArticleHeadlineView(article: Article){
    val containerShape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp, bottomEnd = 20.dp, bottomStart = 20.dp)

    Surface(shape = containerShape, modifier = Modifier.shadow(elevation = 2.dp, shape = containerShape)){
        Box(modifier = Modifier.size(width = 320.dp, height = 280.dp).background(color = MaterialTheme.colorScheme.surface)) {
            Surface(modifier = Modifier.height(height = 200.dp)){
                NetworkImage(imageUrl = article.image_url, modifier = Modifier.fillMaxSize())
            }
            Box(modifier = Modifier.align(alignment = Alignment.TopEnd).padding(10.dp)){
                Surface(shape = RoundedCornerShape(30), color = MaterialTheme.colorScheme.secondary){
                    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Icon(modifier = Modifier.size(18.dp), imageVector = AlarmClock, contentDescription = "")
                        Text(text = Utility.parseDate(article.pubDate).duration(), fontSize = 12.sp, color = MaterialTheme.colorScheme.onPrimary)
                    }
                }
            }
            Surface(modifier = Modifier.align(Alignment.BottomStart), color = MaterialTheme.colorScheme.surfaceContainerHigh, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)){
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Surface(modifier = Modifier.size(width = 60.dp, height = 30.dp), shape = RoundedCornerShape(30), color = MaterialTheme.colorScheme.primary){
                        Box {
                            Text(modifier = Modifier.align(Alignment.Center), fontSize = 14.sp, text = article.category.first().localize(), color = MaterialTheme.colorScheme.onPrimary)
                        }
                    }
                    Text(text = article.title, fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurface, letterSpacing = 1.2.sp, maxLines = 3, fontFamily = FontFamily.SansSerif)
                }
            }
        }
    }
}

@Composable
fun ArticleView(article: Article){
    val containerShape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp)

    Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(10.dp)){
        Surface(modifier = Modifier.size(width = 100.dp, height = 100.dp), shape = containerShape){
            NetworkImage(imageUrl = article.image_url, modifier = Modifier.fillMaxSize())
        }
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)){
            Text(text = article.title, fontSize = 16.sp, color = MaterialTheme.colorScheme.secondary, letterSpacing = 1.2.sp, maxLines = 3, fontFamily = FontFamily.SansSerif)
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                Text(fontSize = 12.sp, text = article.category.first().localize(), fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Thin)
                Text(text = Utility.parseDate(article.pubDate).duration(), fontFamily = FontFamily.Monospace, fontSize = 12.sp, fontWeight = FontWeight.Thin)
            }
        }
    }
}

@MobilePreview
@Composable
private fun ArticleHeadlineViewPreview(){
    BNewsTheme {
        ArticleHeadlineView(article = SampleArticleResponse.results.first())
    }
}

@MobilePreview
@Composable
private fun ArticleViewPreview(){
    BNewsTheme {
        Surface {
            ArticleView(article = SampleArticleResponse.results.first())
        }
    }
}