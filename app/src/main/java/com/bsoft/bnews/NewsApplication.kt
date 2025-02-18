package com.bsoft.bnews

import android.app.Application
import android.content.Context
import android.util.Log
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.request.crossfade
import coil3.util.DebugLogger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication: Application(), SingletonImageLoader.Factory {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "coming inside onCreate")
        SingletonImageLoader.setSafe { context ->
            ImageLoader.Builder(context).logger(DebugLogger()).crossfade(true).build()
        }
    }

    override fun newImageLoader(context: Context): ImageLoader {
        return ImageLoader.Builder(context)
            .crossfade(true)
            .build()
    }

    companion object{
        const val TAG = "NewsApplication"
    }
}