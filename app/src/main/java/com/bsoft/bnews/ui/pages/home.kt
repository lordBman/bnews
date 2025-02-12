package com.bsoft.bnews.ui.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bsoft.bnews.ui.components.SearchViewPreview
import com.bsoft.bnews.ui.icons.More_vert
import com.bsoft.bnews.ui.icons.Search
import com.bsoft.bnews.ui.icons.Star
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview
import com.bsoft.bnews.viewmodels.NewsDataViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(newsDataViewModel: NewsDataViewModel? = hiltViewModel()){
    val textFieldState = rememberTextFieldState()
    var expanded by rememberSaveable { mutableStateOf(false) }

    val inputField = SearchBarDefaults.InputField(
        state = textFieldState,
        onSearch = { expanded = false },
        expanded = expanded,
        onExpandedChange = { expanded = it },
        placeholder = { Text("News Search...") },
        leadingIcon = { Icon(Search, contentDescription = null) },
    )

    Surface(modifier = Modifier.fillMaxSize().semantics { isTraversalGroup = true }) {
        SearchBar(inputField = { inputField }, expanded = expanded, onExpandedChange = { expanded = it }){
            Column(Modifier.verticalScroll(rememberScrollState())) {
                repeat(4) { idx ->
                    val resultText = "Suggestion $idx"
                    ListItem(
                        headlineContent = { Text(resultText) },
                        supportingContent = { Text("Additional info") },
                        leadingContent = { Icon(Star, contentDescription = null) },
                        colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                        modifier =
                        Modifier.clickable {
                            textFieldState.setTextAndPlaceCursorAtEnd(resultText)
                            expanded = false
                        }
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@MobilePreview
@Composable
fun HomePagePreview(){
    BNewsTheme {
        HomePage(newsDataViewModel = null)
    }
}