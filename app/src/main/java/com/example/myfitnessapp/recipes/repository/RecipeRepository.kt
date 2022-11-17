package com.example.myfitnessapp.recipes.repository

import com.example.myfitnessapp.recipes.domain.model.Recipe

interface RecipeRepository {
    suspend fun search(token: String, page: Int, query: String): List<Recipe>
    suspend fun getRecipe(token: String, id: Int): Recipe
}