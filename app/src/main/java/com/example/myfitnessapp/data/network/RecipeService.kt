package com.example.myfitnessapp.data.network

import com.example.myfitnessapp.data.network.model.RecipeDto
import com.example.myfitnessapp.data.network.responses.RecipeSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
// retrofit service: use annotations to describe the functions do, so these are both get requests
// suspend = coroutine function
// coroutines allow us to create asynchronous programs in a fluent way
// The suspend keyword means that this function can be blocking. Such a function can suspend a search coroutine.

// ex: GET: https://food/api/recipe/search/?page=2&query=beef carrot potato
interface RecipeService {
    //search recipes
    @GET("search")
    suspend fun search(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): Response<RecipeSearchResponse>
    //find by recipe id
    @GET("get")
    suspend fun getRecipe(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): Response<RecipeDto>
}