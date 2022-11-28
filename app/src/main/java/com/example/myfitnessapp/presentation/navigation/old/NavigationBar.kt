package com.example.myfitnessapp.presentation.navigation.old
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myfitnessapp.MyFitnessApp
import com.example.myfitnessapp.presentation.ui.screens.profileView.ProfileView
import com.example.myfitnessapp.presentation.ui.screens.programCreation.ProgramCreationView
import com.example.myfitnessapp.presentation.ui.screens.programView.MyProgramView
import com.example.myfitnessapp.presentation.ui.viewmodel.RecipeViewModel
import com.example.myfitnessapp.network.internet_Connectivity.ConnectivityObserver
import com.example.myfitnessapp.network.internet_Connectivity.NetworkConnectivityObserver
import com.example.myfitnessapp.presentation.components.navbar.BottomNavItem
import com.example.myfitnessapp.presentation.components.navbar.EndPoints
import com.example.myfitnessapp.presentation.ui.screens.exercises.navigation.MainActions
import com.example.myfitnessapp.presentation.ui.screens.explore.RecipeListScreen
import com.example.myfitnessapp.presentation.ui.screens.explore.RecipesScreen
import com.example.myfitnessapp.presentation.util.RecipeEvent


private lateinit var connectivityObserver: ConnectivityObserver
@Composable
fun NavigationBar(navController: NavHostController) {

    val actions = remember(navController) { MainActions(navController) }
    val applicationContext= MyFitnessApp.getContext()


    NavHost(navController, startDestination = BottomNavItem.Workouts.screen_route) {

        composable(BottomNavItem.Explore.screen_route) {
            val status by connectivityObserver.observe().collectAsState(
                initial = ConnectivityObserver.Status.Unavailable
            )

            if (status.name =="Available"){
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RecipeListScreen(navController, actions = actions)
                }

            }else  {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Network status: $status ")
                }
            }
        }
        //RecipesScreen
        composable(
            "${BottomNavItem.MovieDetails.screen_route}/{id}",
            arguments = listOf(navArgument(EndPoints.ID) { type = NavType.StringType })
        ) {
            val viewModel = hiltViewModel<RecipeViewModel>(it)
            val IDINT = it.arguments?.getString(EndPoints.ID)
                ?: throw IllegalStateException("'IDINT No' shouldn't be null")
            viewModel.onTriggerEvent(RecipeEvent.GetRecipeEvent(IDINT.toInt()))

            RecipesScreen(viewModel,navController)
        }

        composable(BottomNavItem.AddProgram.screen_route) {
            ProgramCreationView()
        }
        composable(BottomNavItem.MyProgram.screen_route) {
            MyProgramView()
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileView()
        }
    }
}
