package com.example.myfitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myfitnessapp.screens.detail.DetailViewModel
import com.example.myfitnessapp.screens.detail.HomeViewModel
import com.example.myfitnessapp.screens.login.LoginViewModel


import com.example.myfitnessapp.ui.theme.MyFitnessAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val loginViewModel = viewModel(modelClass = LoginViewModel::class.java)
            val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
            val programViewModel = viewModel(modelClass = DetailViewModel::class.java)
            MyFitnessAppTheme {
                // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Navigation(
                            loginViewModel = loginViewModel,
                            homeViewModel = homeViewModel,
                            detailViewModel = programViewModel
                        )
                    }


            }
        }
    }
}




