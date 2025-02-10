package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.bsoft.bnews.R
import com.bsoft.bnews.ui.LocalRootNavController
import com.bsoft.bnews.utils.RootRoutes
import com.bsoft.bnews.viewmodels.SettingsViewModel


@Composable
fun LoadingScreen(settingsViewModel: SettingsViewModel = hiltViewModel()){
    val navController = LocalRootNavController.current
    val settingsState by settingsViewModel.state.collectAsState()

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_four))

    fun transit(){
        val nextRoute = if(settingsState.firstTime) { RootRoutes.onboarding } else { RootRoutes.main }

        navController.navigate(nextRoute){
            popUpTo(RootRoutes.loading)
        }
    }

    Surface(modifier = Modifier.fillMaxSize()){
        Surface (modifier = Modifier.fillMaxSize()) {
            Box(contentAlignment = Alignment.Center){
                LottieAnimation(
                    composition = composition,
                    //iterations = LottieConstants.IterateForever,
                    //clipSpec = LottieClipSpec.Progress(0.5f, 0.75f),
                )
            }
            Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.padding(all = 10.dp)){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(strokeWidth = 2.dp)
                    Spacer(Modifier.height(8.dp))
                    Text("Loading, please wait ...")
                }
            }
        }
    }
}