package com.example.myfitnessapp.presentation.util

sealed class RecipeListEvent {
    object SearchEvent : RecipeListEvent()
    object NextPageEvent : RecipeListEvent()

    //restore after process death
    object RestoreEvent : RecipeListEvent()
}