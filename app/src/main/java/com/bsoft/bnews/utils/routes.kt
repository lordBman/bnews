package com.bsoft.bnews.utils

import androidx.compose.ui.graphics.vector.ImageVector
import com.bsoft.bnews.ui.icons.Cog
import com.bsoft.bnews.ui.icons.HomeIcon

object RootRoutes {
    const val loading = "Loading"
    const val main = "Main"
    const val info = "Info"
    const val onboarding = "OnBoarding"
}

enum class PageRoute(val title: String, val icon: ImageVector){
    Home("Home", icon = HomeIcon),
    Settings("Settings", icon = Cog)
}