package com.example.myfitnessapp.recipes.presentation.util

sealed class RecipeEvent {
    data class GetRecipeEvent(val id: Int) : RecipeEvent()
}
