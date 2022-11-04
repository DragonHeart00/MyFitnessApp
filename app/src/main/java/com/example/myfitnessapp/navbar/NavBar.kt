package com.example.myfitnessapp.navbar

import com.example.myfitnessapp.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Explore", R.drawable.ic_explore,"explore")
    object MyNetwork: BottomNavItem("Favorite",R.drawable.ic_favorite,"favorite")
    object AddPost: BottomNavItem("Add",R.drawable.ic_add,"add")
    object Notification: BottomNavItem("My Program",R.drawable.ic_my_program,"my_program")
    object Jobs: BottomNavItem("Profile",R.drawable.ic_profile,"profile")
}