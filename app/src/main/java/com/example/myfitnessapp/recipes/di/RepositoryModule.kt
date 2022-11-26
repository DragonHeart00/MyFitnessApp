package com.example.myfitnessapp.recipes.di

import com.example.myfitnessapp.recipes.network.RecipeService
import com.example.myfitnessapp.recipes.network.model.RecipeDtoMapper
import com.example.myfitnessapp.recipes.repository.RecipeRepository
import com.example.myfitnessapp.recipes.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepository(recipeService: RecipeService, recipeDtoMapper: RecipeDtoMapper): RecipeRepository {

        return RecipeRepositoryImpl(
            recipeService,
            recipeDtoMapper
        )

    }
}