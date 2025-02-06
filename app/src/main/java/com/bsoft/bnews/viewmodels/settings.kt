package com.bsoft.bnews.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class SettingsState(val language: String);

@HiltViewModel
class SettingsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    val state = savedStateHandle.getStateFlow("settings", SettingsState(language = "en"))
}