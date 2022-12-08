package com.example.myfitnessapp.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myfitnessapp.R

/**
 * A navigation graph defines all possible routes into the application
 *
 */
const val ROOT_ROUTE = "root_route"
const val LOGIN_ROUTE = "login_route"
const val MAIN_ROUTE = "main_route"

sealed class Screens(
    val route: String,
    @StringRes
    val title: Int, val icon: ImageVector? = null
) {
    object SplashScreen : Screens(route = "splash_screen", title = R.string.splash)
    object Home : Screens(route = "home_screen", title = R.string.home, icon = Icons.Rounded.Home)
    object Login : Screens(route = "login_screen", title = R.string.login)
    object Signup : Screens(route = "signup_screen", title = R.string.signup)
    object Explore :
        Screens(route = "explore_screen", title = R.string.explore, icon = Icons.Rounded.Explore)

    object Profile :
        Screens(route = "profile_screen", title = R.string.profile, icon = Icons.Rounded.Person)

    object Exercises : Screens(
        route = "exercises_screen",
        title = R.string.exercises,
        icon = Icons.Rounded.FitnessCenter
    )

    object ExerciseDetails : Screens(route = "exercises_details_screen", title = R.string.exercise)
    object WorkoutPlanSetUp : Screens(route = "workout_plan_setup_screen", title = R.string.set_up_workout_plan_heading)

    object RecipeDetails : Screens(route = "recipes_screen", title = R.string.recipes_screen)


}
