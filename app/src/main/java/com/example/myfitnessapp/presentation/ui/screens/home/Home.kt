package com.example.myfitnessapp.presentation.ui.screens.home
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.myfitnessapp.NavigationBar
import com.example.myfitnessapp.presentation.components.navbar.BottomNavigation

@Composable
fun Home(homeViewModal: HomeViewModal, navToLoginPage: () -> Unit){
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                navigationIcon = {},
                actions = {
                    IconButton(onClick = {
                        homeViewModal?.signOut()
                        navToLoginPage.invoke()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = null,
                        )
                    }
                },
                title = {
//                    Text(text = "Home")
                }
            )
        }

    ) {
        MainScreenView()
    }
//    MainScreenView()
}


@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        NavigationBar(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    MainScreenView()
}