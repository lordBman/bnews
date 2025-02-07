package com.bsoft.bnews.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class SettingsState(val language: String = "en");

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {
    private val mutableStateFlow = MutableStateFlow(SettingsState())
    val state = mutableStateFlow.asStateFlow()
}
/*class SettingsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    val state = savedStateHandle.getStateFlow("settings", SettingsState())
}*/