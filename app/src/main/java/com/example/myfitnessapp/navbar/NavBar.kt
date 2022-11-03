package com.example.myfitnessapp.navbar

import com.example.myfitnessapp.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object MyNetwork: BottomNavItem("My Network",R.drawable.ic_home,"my_network")
    object AddPost: BottomNavItem("Post",R.drawable.ic_home,"add_post")
    object Notification: BottomNavItem("Notification",R.drawable.ic_home,"notification")
    object Jobs: BottomNavItem("Jobs",R.drawable.ic_home,"jobs")
}