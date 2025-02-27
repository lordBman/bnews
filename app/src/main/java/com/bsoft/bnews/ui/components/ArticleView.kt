package com.bsoft.bnews.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
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
fun ArticleHeadlineView(article: Article, clicked: ((id: String)-> Unit)? = null){
    val containerShape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp, bottomEnd = 20.dp, bottomStart = 20.dp)

    fun onclick(){
        clicked?.invoke(article.article_id)
    }

    Surface(shape = containerShape, shadowElevation = 2.dp, modifier = Modifier.clickable { onclick() }){
        Box(modifier = Modifier.size(width = 320.dp, height = 280.dp).background(color = MaterialTheme.colorScheme.surface)) {
            Surface(modifier = Modifier.height(height = 200.dp)){
                NetworkImage(imageUrl = article.image_url, modifier = Modifier.fillMaxSize())
            }
            Box(modifier = Modifier.align(alignment = Alignment.TopEnd).padding(10.dp)){
                Surface(shape = RoundedCornerShape(30), color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.7f)){
                    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Icon(modifier = Modifier.size(18.dp), imageVector = AlarmClock, contentDescription = "", tint = MaterialTheme.colorScheme.onSecondary)
                        Text(text = Utility.parseDate(article.pubDate).duration(), fontSize = 12.sp, color = MaterialTheme.colorScheme.onSecondary)
                    }
                }
            }
            Surface(modifier = Modifier.align(Alignment.BottomStart), color = MaterialTheme.colorScheme.surfaceContainerHigh, shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)){
                Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Surface(modifier = Modifier.defaultMinSize(minWidth = 60.dp, minHeight = 30.dp), shape = RoundedCornerShape(30), color = MaterialTheme.colorScheme.primary){
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
fun ArticleView(article: Article, clicked: ((id: String)-> Unit)? = null){
    val containerShape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp)

    fun onclick(){
        clicked?.invoke(article.article_id)
    }

    Row(modifier = Modifier.clickable { onclick() }, verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(10.dp)){
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

@Composable
fun ArticleFullView(article: Article){
    val containerShape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp, bottomEnd = 10.dp, bottomStart = 10.dp)
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize().verticalScroll(state = scrollState, enabled = true)){
        Surface(modifier = Modifier.fillMaxWidth()){
            NetworkImage(imageUrl = article.image_url, modifier = Modifier.fillMaxSize())
        }
        Box(modifier = Modifier.padding(20.dp)){
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)){
                Surface(shadowElevation = 2.dp, shape = containerShape, color = MaterialTheme.colorScheme.surfaceContainerHigh){
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth().padding(10.dp)){
                        Surface(modifier = Modifier.size(size = 60.dp), shape = RoundedCornerShape(size = 10.dp)){
                            NetworkImage(imageUrl = article.source_icon, priority = Priority.Width, modifier = Modifier.fillMaxSize())
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)){
                            Text(text = article.source_name, fontSize = 12.sp)
                            Text(text = article.source_url, fontSize = 12.sp, color = MaterialTheme.colorScheme.secondary)
                        }
                    }
                }
                Column(horizontalAlignment = Alignment.End){
                    Text(text = article.title, style = TextStyle(), fontSize = 18.sp, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold, letterSpacing = 1.2.sp, fontFamily = FontFamily.SansSerif)
                    Text(text = Utility.parseDate(article.pubDate).duration(), fontFamily = FontFamily.Monospace, fontSize = 12.sp, fontWeight = FontWeight.Thin)
                }
                Text(text = article.description, fontSize = 15.sp)
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

@MobilePreview
@Composable
private fun ArticleFullViewPreview(){
    BNewsTheme {
        Surface {
            ArticleFullView(article = SampleArticleResponse.results.first())
        }
    }
}