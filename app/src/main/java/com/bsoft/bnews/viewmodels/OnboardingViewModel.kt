package com.bsoft.bnews.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsoft.bnews.utils.DataStoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val dataStoreManager: DataStoreManager) : ViewModel() {
    // Expose the onboarding completion status as a StateFlow
    val isOnboardingCompleted = dataStoreManager.isOnboardingCompleted

    // Function to mark onboarding as completed
    fun markOnboardingCompleted() {
        viewModelScope.launch {
            dataStoreManager.saveOnboardingCompleted(true)
        }
    }
}