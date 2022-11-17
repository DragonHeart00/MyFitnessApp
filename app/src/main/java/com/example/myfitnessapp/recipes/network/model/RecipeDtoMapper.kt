package com.example.myfitnessapp.recipes.network.model

import com.example.myfitnessapp.recipes.domain.model.Recipe
import com.example.myfitnessapp.recipes.domain.util.DomainMapper


class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return with(model) {
            return@with Recipe(
                id,
                title,
                publisher,
                featuredImage,
                rating,
                sourceUrl,
                description,
                cookingInstructions,
                ingredients ?: listOf(),
                dateAdded,
                dateUpdated
            )
        }
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return with(domainModel) {
            return@with RecipeDto(
                id, title,
                publisher,
                featuredImage,
                rating,
                sourceUrl,
                description,
                cookingInstructions,
                ingredients,
                dateAdded,
                dateUpdated
            )
        }
    }

    fun toDomainList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map {
            mapToDomainModel(it)
        }
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map {
            mapFromDomainModel(it)
        }
    }
}