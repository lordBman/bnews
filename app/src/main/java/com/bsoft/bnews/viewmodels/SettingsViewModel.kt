package com.bsoft.bnews.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class SettingsState(
    val language: String = "en",
    val firstTime: Boolean
);

@HiltViewModel
class SettingsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    val state = savedStateHandle.getStateFlow("settings", SettingsState( firstTime = !savedStateHandle.contains("setting")))
}