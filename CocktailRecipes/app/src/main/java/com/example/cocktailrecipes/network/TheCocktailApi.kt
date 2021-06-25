package com.example.cocktailrecipes.network

import com.example.cocktailrecipes.data.DrinkListRemoteEntity
import retrofit2.http.GET

interface TheCocktailApi {
    @GET("filter.php?a=Alcoholic")
    suspend fun getCocktail(): DrinkListRemoteEntity
}