package com.example.myfitnessapp.data.repository

import com.example.myfitnessapp.domain.models.Recipe
import com.example.myfitnessapp.data.network.RecipeService
import com.example.myfitnessapp.data.network.model.RecipeDtoMapper
import com.example.myfitnessapp.domain.repository.RecipeRepository
// recipe entity come from retrofit service and convert into recipe
// inside repository we have a mapper class
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

    //getRecipe: recipe entity comes into a mapper and come out as a recipe
    override suspend fun getRecipe(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(
            recipeService.getRecipe(
                token,
                id
            ).body()!!
        )
    }
}