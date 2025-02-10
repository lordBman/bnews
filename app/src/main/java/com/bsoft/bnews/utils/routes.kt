package com.bsoft.bnews.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

object RootRoutes {
    const val loading = "Loading"
    const val main = "Main"
    const val info = "Info"
    const val onboarding = "OnBoarding"
}

enum class PageRoute(val title: String, val icon: ImageVector){
    Home("Home", icon = Icons.Outlined.Home),
    Settings("Settings", icon = Icons.Outlined.Settings)
}