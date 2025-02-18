package com.bsoft.bnews.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview

@Composable
fun Category(modifier: Modifier = Modifier, label: String, active: Boolean = false, onChoose: (chosen: String)-> Unit){
    val theme = MaterialTheme.colorScheme
    val border = BorderStroke(width = 2.dp, color = theme.secondary);
    val shape = RoundedCornerShape(size = 10.dp)
    val color = if(active){ theme.secondary } else { Color.Transparent }
    val textColor = if(active) { theme.onSecondary } else { theme.secondary }

    Surface(modifier = modifier.defaultMinSize(minWidth = 100.dp).clickable { onChoose(label); }, border = border, shape = shape , color = color){
        Box(contentAlignment = Alignment.Center){
            Text(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), text = label, color = textColor, fontSize = 16.sp)
        }
    }
}

@Composable
fun Categories(modifier: Modifier = Modifier, active: String, labels: List<String>, padding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 10.dp), onChoose: (chosen: String)-> Unit){
    if(!labels.contains(active)){
        throw Error("active parameter: $active must in the labels($labels) provided")
    }

    val scrollState = rememberScrollState()
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp), modifier =  modifier.fillMaxWidth().horizontalScroll(state = scrollState, enabled = true).padding(padding)){
        labels.map {
            Category(label = it, active = active == it) { chosen -> onChoose(chosen); }
        }
    }
}

@MobilePreview
@Composable
private fun CategoryPreview(){
    BNewsTheme {
        Surface {
            Category(label = "All") { }
        }
    }
}

@MobilePreview
@Composable
private fun CategoriesPreview(){
    val list = listOf("All", "Sports", "Music", "Entertainment", "Politics", "Business", "Crime")
    var active by remember {
        mutableStateOf("All")
    }

    BNewsTheme {
        Surface {
            Categories(labels = list, active = active) { active = it }
        }
    }
}