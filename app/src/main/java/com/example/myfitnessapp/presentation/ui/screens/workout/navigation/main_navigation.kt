package com.example.myfitnessapp.presentation.ui.screens.workout.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.navigation.NavigaionScreen
import com.example.myfitnessapp.presentation.ui.screens.workout.HomeScreen
import com.example.myfitnessapp.presentation.ui.screens.workout.ProgramDetails

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigaionScreen.MainScreen.name) {


        composable(
            NavigaionScreen.MainScreen.name
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            NavigaionScreen.DetailsScreen.name +"/{userId}",
            arguments = listOf(navArgument(name = "userId") {
                type =
                    NavType.StringType
            })
        )

        { backStackEntry ->
            ProgramDetails(
                navController = navController, backStackEntry.arguments?.getString("userId")

            )
        }
    }
}