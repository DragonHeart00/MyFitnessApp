package com.example.myfitnessapp.presentation.util

sealed class RecipeEvent {
    data class GetRecipeEvent(val id: Int) : RecipeEvent()
}
