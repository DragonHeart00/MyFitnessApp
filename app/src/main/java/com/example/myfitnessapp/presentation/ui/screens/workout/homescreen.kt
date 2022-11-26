package com.example.myfitnessapp.presentation.ui.screens.workout

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.navigation.NavigaionScreen
import com.example.myfitnessapp.domain.model.getProgram
import com.example.myfitnessapp.presentation.ui.screens.workout.widget.BuildList


@Composable
fun HomeScreen(navController: NavController) {


    BuildBody(navController)
}


@Composable
fun BuildBody(navController: NavController?) {
    Scaffold(topBar = {
        TopAppBar(
            elevation = 3.dp,


            backgroundColor = Color.White
        ) {

            Text(text = "UnderStanding JetPack Compose", color = Color.Black)

        }
    }) {
        BuildList(list = getProgram()) {
                id->
            navController?.navigate(route = NavigaionScreen.DetailsScreen.name+ "/$id")
        }
    }

}
