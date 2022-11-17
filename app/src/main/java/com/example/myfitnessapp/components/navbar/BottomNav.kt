package com.example.myfitnessapp.components.navbar


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.myfitnessapp.MyFitnessApp
import com.example.myfitnessapp.R
import com.example.myfitnessapp.presentation.ui.viewmodel.RecipeViewModel
import com.example.myfitnessapp.recipes.network.internet_Connectivity.ConnectivityObserver
import com.example.myfitnessapp.recipes.network.internet_Connectivity.NetworkConnectivityObserver
import com.example.myfitnessapp.recipes.presentation.ui.fragment.RecipeListScreen
import com.example.myfitnessapp.recipes.presentation.ui.fragment.RecipesScreen
import com.example.myfitnessapp.recipes.presentation.util.RecipeEvent
import com.example.myfitnessapp.components.screens.favoriteView.FavoriteView
import com.example.myfitnessapp.components.screens.profileView.ProfileView
import com.example.myfitnessapp.components.screens.programCreation.ProgramCreationView
import com.example.myfitnessapp.components.screens.programView.MyProgramView

object EndPoints {
    const val ID = "id"
}

private lateinit var connectivityObserver: ConnectivityObserver


@Composable
fun BottomNavigation(navController: NavController) {

    val items = listOf(
        BottomNavItem.Explore,
        BottomNavItem.Favorite,
        BottomNavItem.AddProgram,
        BottomNavItem.MyProgram,
        BottomNavItem.Profile
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.bar),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {

    val actions = remember(navController) { MainActions(navController) }
    val applicationContext= MyFitnessApp.getContext()
    connectivityObserver = NetworkConnectivityObserver(applicationContext)


    NavHost(navController, startDestination = BottomNavItem.Explore.screen_route) {
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

            RecipesScreen(viewModel, actions,navController)
        }



        composable(BottomNavItem.Favorite.screen_route) {
            FavoriteView()
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


class MainActions(navController: NavController) {

    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val gotoRecipeDetails: (String) -> Unit = { isbnNo ->
        navController.navigate("${BottomNavItem.MovieDetails.screen_route}/$isbnNo")
    }

    val gotoRecipeList: () -> Unit = {
        navController.navigate(BottomNavItem.Favorite.screen_route)
    }
}

