package com.example.myfitnessapp.recipes.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myfitnessapp.recipes.presentation.components.animation.CircularIndeterminateProgressBar
import com.example.myfitnessapp.recipes.presentation.components.DefaultSnackbar
import com.example.myfitnessapp.recipes.presentation.components.animation.LoadingAnimation

private val LightThemeColors = lightColors(
    primary = Primary,
    primaryVariant = PrimaryVariant,
    onPrimary = White,
    secondary = Secondary,
    secondaryVariant = SecondaryVariant,
    onSecondary = Black,
    error = ErrorRedDark,
    onError = White,
    background = FaintGray,
    onBackground = Black,
    surface = White,
    onSurface = Black
)

private val DarkThemeColors = darkColors(
    primary = Pink300,
    primaryVariant = PrimaryVariant,
    onPrimary = Black,
    secondary = Secondary,
    secondaryVariant = SecondaryVariant,
    onSecondary = Black,
    error = ErrorRedLight,
    onError = Black,
    background = JustBlack,
    onBackground = White,
    surface = JustBlack,
    onSurface = White
)

@Composable
fun AppTheme(
    isProgressBarShowing: Boolean,
    scaffoldState: ScaffoldState,
    snackbarAlignment: Alignment,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors =  LightThemeColors,
        typography = QuickSandTypography,
        shapes = AppShapes
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = FaintGray
                )
        ) {
            content()
           //CircularIndeterminateProgressBar(isProgressBarShowing, 0.7f)

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoadingAnimation(isProgressBarShowing)
            }

            DefaultSnackbar(
                snackbarHostState = scaffoldState.snackbarHostState,
                modifier = Modifier.align(snackbarAlignment)
            ) {
                scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
            }
        }
    }
}