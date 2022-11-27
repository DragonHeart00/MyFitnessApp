package com.example.myfitnessapp.presentation.ui.screens.explore

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myfitnessapp.presentation.ui.screens.home.Title
import com.example.myfitnessapp.ui.theme.myDarkBlue


@Composable
fun ExploreScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = myDarkBlue) {

        Title(text = "coming soon", modifier = Modifier.fillMaxSize())

    }
}