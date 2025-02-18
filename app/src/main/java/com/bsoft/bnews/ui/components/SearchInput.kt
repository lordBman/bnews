package com.bsoft.bnews.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoft.bnews.ui.icons.ArrowLeft
import com.bsoft.bnews.ui.icons.Search
import com.bsoft.bnews.ui.icons.XCircle
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SearchInput(modifier: Modifier = Modifier, value: String, onFocusChange: ((Boolean)->Unit)? = null, onTextChange: (String)->Unit) {
    val focusManager = LocalFocusManager.current // Get the FocusManager
    val textStyle = TextStyle(fontSize = 14.sp)

    val interactionSource = remember { MutableInteractionSource() }
    val focusState = interactionSource.collectIsFocusedAsState()


    // Observe focusState changes
    LaunchedEffect(focusState) {
        snapshotFlow { focusState.value }.collectLatest { isFocused ->
            onFocusChange?.invoke(isFocused)
        }
    }

    fun removeFocus(){
        onTextChange.invoke("")
        focusManager.clearFocus(force = true)
    }

    OutlinedTextField(modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = {
            onTextChange.invoke(it)
        },
        textStyle = textStyle,
        singleLine = true,
        interactionSource = interactionSource,
        colors = TextFieldDefaults.colors(),
        trailingIcon = {
            if(focusState.value){
                Icon(XCircle, contentDescription = null, modifier = Modifier.clickable { removeFocus() })
            }
        },
        leadingIcon = {
            if(focusState.value){
                Icon(ArrowLeft, contentDescription = null, modifier = Modifier.clickable { removeFocus() })
            }else{
                Icon(Search, contentDescription = null)
            }
        },
        shape = RoundedCornerShape(50.dp),
        placeholder = { Text(text = "News Search...", style = textStyle) }
    )
}

@MobilePreview
@Composable
fun SearchInputPreview(){
    var inFocus by remember {  mutableStateOf(false)  }
    var text by remember { mutableStateOf("") }

    BNewsTheme {
        Surface {
            Column(modifier = Modifier.fillMaxWidth().padding(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                SearchInput(value = text, onFocusChange = { inFocus = it }){
                    text = it
                }
                Text("You typed: $text")
                Text("You are in focus: $inFocus")
            }
        }
    }
}