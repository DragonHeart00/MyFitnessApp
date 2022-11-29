package com.example.myfitnessapp.presentation.ui.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

import com.example.myfitnessapp.presentation.components.animation.LottieAsset
import com.example.myfitnessapp.presentation.navigation.MAIN_ROUTE
import com.example.myfitnessapp.presentation.navigation.Screens
import com.example.myfitnessapp.presentation.ui.viewmodel.UserViewModel
import com.example.myfitnessapp.presentation.ui.viewmodel.WorkoutViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(
    navController: NavHostController = rememberNavController(),
    userViewModel: UserViewModel,
)  {

    LaunchedEffect(key1 = userViewModel?.hasUser){
        delay(2000L)
        if (userViewModel.hasUser){
            navController.navigate(Screens.Home.route)
        }else {
            navController.navigate(Screens.Login.route)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAsset(asset = "wait.json")

    }
}
