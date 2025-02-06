package com.bsoft.bnews.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.bsoft.bnews.viewmodels.SettingsViewModel

@Composable
fun SettingsPage(settingsViewModel: SettingsViewModel = hiltViewModel<SettingsViewModel>()){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
            Text("Setting Page")
        }
    }
}

@Composable
@Preview
fun SettingsPagePreview(){
    SettingsPage()
}