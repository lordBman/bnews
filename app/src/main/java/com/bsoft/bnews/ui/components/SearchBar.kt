package com.bsoft.bnews.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bsoft.bnews.ui.icons.More_vert
import com.bsoft.bnews.ui.icons.Search
import com.bsoft.bnews.ui.icons.Star
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview

@Composable
private fun CustomTextField(textChange: (text: String)-> Unit){
    val valueState = remember { mutableStateOf("") }
    var value by valueState

    LaunchedEffect(valueState) {
        snapshotFlow { value }.collect {
            textChange(value)
        }
    }

    TextField(value = value, onValueChange = { value = it })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(){
    var text by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    SearchBar(expanded = expanded, onExpandedChange = { expanded = it }, inputField = { CustomTextField(textChange = { text = it }) } ) {
        Text("Search")
    }
}

@Composable
@MobilePreview
fun SearchViewPreview(){
    BNewsTheme {
        Surface {
            SearchView()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchBarSample() {
    val textFieldState = rememberTextFieldState()
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(Modifier.fillMaxSize().semantics { isTraversalGroup = true }) {
        SearchBar(
            modifier = Modifier.align(Alignment.TopCenter).semantics { traversalIndex = 0f },
            inputField = {
                SearchBarDefaults.InputField(
                    state = textFieldState,
                    onSearch = { expanded = false },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = { Text("Hinted search text") },
                    leadingIcon = { Icon(Search, contentDescription = null) },
                    trailingIcon = { Icon(More_vert, contentDescription = null) },
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
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

        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, top = 72.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.semantics { traversalIndex = 1f },
        ) {
            val list = List(100) { "Text $it" }
            items(count = list.size) {
                Text(
                    text = list[it],
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                )
            }
        }
    }
}