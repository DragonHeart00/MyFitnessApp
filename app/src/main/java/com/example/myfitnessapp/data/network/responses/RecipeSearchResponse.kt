package com.example.myfitnessapp.data.network.responses

import com.example.myfitnessapp.data.network.model.RecipeDto
import com.google.gson.annotations.SerializedName
//response for that search request to the network
data class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int,
    @SerializedName("results")
    var recipes: List<RecipeDto>
)