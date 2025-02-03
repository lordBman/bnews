package com.bsoft.bnews.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

data class SettingsState(val language: String);

@HiltViewModel
class SettingsViewModel : ViewModel() {}