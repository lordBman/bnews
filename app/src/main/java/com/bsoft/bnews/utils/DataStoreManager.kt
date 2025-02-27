package com.bsoft.bnews.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "settings")

class DataStoreManager(private val context: Context) {
    private val onboardingCompletedKey = booleanPreferencesKey("isOnboardingCompleted")

    val isOnboardingCompleted: Flow<Boolean> = context.dataStore.data.map {
        it[onboardingCompletedKey] ?: false
    }

    suspend fun saveOnboardingCompleted(completed: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[onboardingCompletedKey] = completed
        }
    }
}