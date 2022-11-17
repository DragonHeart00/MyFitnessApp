package com.example.myfitnessapp.recipes.repository

import com.example.myfitnessapp.recipes.domain.model.Recipe
import com.example.myfitnessapp.recipes.network.RecipeService
import com.example.myfitnessapp.recipes.network.model.RecipeDtoMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
) : RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(
            recipeService.search(
                token, page, query
            ).body()!!.recipes
        )
    }

    override suspend fun getRecipe(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(
            recipeService.getRecipe(
                token,
                id
            ).body()!!
        )
    }
}