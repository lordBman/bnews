package com.bsoft.bnews.utils

import androidx.compose.ui.graphics.vector.ImageVector
import com.bsoft.bnews.ui.icons.ArchiveBox
import com.bsoft.bnews.ui.icons.Cog
import com.bsoft.bnews.ui.icons.HomeIcon

object RootRoutes {
    const val loading = "Loading"
    const val main = "Main"
    const val info = "Info"
    const val onboarding = "OnBoarding"
    const val search = "Search"
    const val article = "Article"
}

enum class PageRoute(val title: String, val icon: ImageVector){
    Home("Home", icon = HomeIcon),
    Saved("Saved", icon = ArchiveBox),
    Settings("Settings", icon = Cog)
}