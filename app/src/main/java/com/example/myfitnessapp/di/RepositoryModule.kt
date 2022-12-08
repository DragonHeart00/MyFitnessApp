package com.example.myfitnessapp.di

import com.example.myfitnessapp.data.network.RecipeService
import com.example.myfitnessapp.data.network.model.RecipeDtoMapper
import com.example.myfitnessapp.domain.repository.RecipeRepository
import com.example.myfitnessapp.data.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {

        return RecipeRepositoryImpl(
            recipeService,
            recipeDtoMapper
        )

    }
}