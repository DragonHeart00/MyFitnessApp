package com.example.myfitnessapp.recipes.presentation.ui.fragment

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myfitnessapp.components.navbar.MainActions
import com.example.myfitnessapp.presentation.ui.viewmodel.RecipeViewModel
import com.example.myfitnessapp.recipes.presentation.components.RecipeView
import com.example.myfitnessapp.recipes.presentation.components.animation.ShimmerRecipeAnimation
import com.example.myfitnessapp.recipes.presentation.theme.AppTheme
import com.example.myfitnessapp.recipes.util.RECIPE_VIEW_HEIGHT
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun RecipesScreen(  viewModel: RecipeViewModel = hiltViewModel() , actions: MainActions, navController : NavController ) {

    //viewModel.onTriggerEvent(RecipeEvent.GetRecipeEvent(movieId.toInt()))
     var isDark: Boolean = false
    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.background
  //   val snackbarController = SnackbarController()
    val allMovies = viewModel.recipe.value


    val loading = viewModel.loading.value
    val scaffoldState = rememberScaffoldState()



    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(
        backgroundColor = MaterialTheme.colors.onPrimary,
        contentColor = MaterialTheme.colors.onSurface,
        topBar = {
            RecipeDetailsTopBar(navController)

        },
        content = {


            AppTheme( loading, scaffoldState, Alignment.BottomCenter) {
                val recipe = viewModel.recipe.value

                Log.e("Omar", recipe.toString())

                Scaffold(
                    scaffoldState = scaffoldState,
                    snackbarHost = { scaffoldState.snackbarHostState }) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colors.background)
                    ) {
                        if (loading && recipe == null) {
                            ShimmerRecipeAnimation(imageHeight = RECIPE_VIEW_HEIGHT)
                        } else {
                            recipe?.let {
                                if (it.id == 1) {
                                   /* snackbarController.showSnackbar(
                                        scaffoldState, "RECIPE WITH ID 1", "ERROR"
                                    )*/
                                } else {
                                    RecipeView(recipe)

                                }
                            }
                        }
                    }
                }
            }
        }
    )
}