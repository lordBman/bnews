package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bsoft.bnews.R
import com.bsoft.bnews.ui.LocalRootNavController
import com.bsoft.bnews.ui.components.Carousel
import com.bsoft.bnews.ui.components.SlideDatum
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview
import com.bsoft.bnews.utils.RootRoutes
import com.bsoft.bnews.viewmodels.OnboardingViewModel

val data = listOf(
    SlideDatum(
        title = "Get connected to the most popular News sources and publishers",
        animation = R.raw.animation_four,
        description = "Stay connected to the most popular news sources and publishers for real-time updates and in-depth coverage. Get breaking news, expert analysis, and top stories from trusted media outlets. Stay informed on politics, business, technology, entertainment, and more. Access reliable news anytime, anywhere, right at your fingertips."
    ),
    SlideDatum(
        title = "Get News reports from all corners around the globe",
        animation = R.raw.animation_five,
        description = "Receive news reports from every corner of the globe, covering the latest events and developments. Stay informed with international coverage on politics, business, technology, culture, and more. Get real-time updates from trusted sources, ensuring you never miss important global stories. Stay connected to the world, no matter where you are."
    ),
    SlideDatum(
        title = "News Articles at your hands on the go",
        animation = R.raw.animation_sevent,
        description = "Access news articles anytime, anywhere, right at your fingertips. Stay updated with the latest stories from top sources while on the go. Get real-time reports on politics, business, technology, entertainment, and more. Stay informed effortlessly, no matter where you are."
    )
)

@Composable
fun OnBoardingScreen(onboardingViewModel: OnboardingViewModel = hiltViewModel()){
    val navController = LocalRootNavController.current

    var index by remember { mutableIntStateOf(0) }

    fun navigateToHome(){
        onboardingViewModel.markOnboardingCompleted()
        navController.navigate(route = RootRoutes.main){
            popUpTo(RootRoutes.onboarding) { inclusive = true } // Remove "splash" from the back stack
        }
    }

    Scaffold {
        Surface(modifier = Modifier.padding(it)){
            Column{
                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), horizontalArrangement = Arrangement.SpaceBetween){
                    Text("Page")
                    Text("${index + 1}/${data.size}")
                }
                Carousel(modifier = Modifier.weight(1f), data = data, home = { navigateToHome() } ){ nextIndex ->
                    index = nextIndex
                }
            }
        }
    }
}

@MobilePreview
@Composable
fun OnBoardingScreenPreview(){
    BNewsTheme {
        OnBoardingScreen()
    }
}