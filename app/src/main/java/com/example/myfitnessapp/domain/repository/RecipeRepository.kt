package com.example.myfitnessapp.domain.repository

import com.example.myfitnessapp.domain.models.Recipe

interface RecipeRepository {
    //suspend pauses the execution of the current coroutine, saving all local variables.
    suspend fun search(token: String, page: Int, query: String): List<Recipe>
    suspend fun getRecipe(token: String, id: Int): Recipe
}