package com.bsoft.bnews.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    fun saveOnboardingCompleted(completed: Boolean) {
        sharedPreferences.edit().putBoolean("isOnboardingCompleted", completed).apply()
    }

    fun isOnboardingCompleted(): Boolean {
        return sharedPreferences.getBoolean("isOnboardingCompleted", false)
    }
}