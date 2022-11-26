package com.example.myfitnessapp.presentation.navigation

import com.example.myfitnessapp.util.Constants.HOME_SCREEN
import com.example.myfitnessapp.util.Constants.SIGN_IN
import com.example.myfitnessapp.util.Constants.SIGN_UP
import com.example.myfitnessapp.util.Constants.SPLASH_SCREEN


sealed class Screen(val route: String) {
    object SplashScreen: Screen(SPLASH_SCREEN)
    object HomeScreen: Screen(HOME_SCREEN)
    object SignInScreen: Screen(SIGN_IN)
    object SignUpScreen: Screen(SIGN_UP)
}