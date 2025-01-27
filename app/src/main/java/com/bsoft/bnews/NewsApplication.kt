package com.bsoft.bnews

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "coming inside onCreate")
    }

    companion object{
        const val TAG = "NewsApplication"
    }
}