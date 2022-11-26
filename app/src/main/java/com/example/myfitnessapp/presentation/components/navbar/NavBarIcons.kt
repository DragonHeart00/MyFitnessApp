package com.example.myfitnessapp.presentation.components.navbar

import com.example.myfitnessapp.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Explore : BottomNavItem("Explore", R.drawable.ic_explore,"explore")
    object Favorite: BottomNavItem("Favorite",R.drawable.ic_favorite,"favorite")
    object AddProgram: BottomNavItem("Add",R.drawable.ic_add,"add")
    object MyProgram: BottomNavItem("My Program",R.drawable.ic_my_program,"my_program")
    object Profile: BottomNavItem("Profile",R.drawable.ic_profile,"profile")

  /*  object MovieDetails : BottomNavItem("recipes_screen/{movieId}",R.drawable.ic_favorite,"recipes_screen/{movieId}") {
        fun passMovieId(movieId: String) = "recipes_screen/$movieId"
    }
*/
    object MovieDetails : BottomNavItem("recipes_screen",R.drawable.ic_profile,"recipes_screen")


}