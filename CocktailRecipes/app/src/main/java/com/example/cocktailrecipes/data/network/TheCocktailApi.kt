package com.example.cocktailrecipes.data.network

import com.example.cocktailrecipes.data.model.DrinkList
import retrofit2.Response
import retrofit2.http.GET

interface TheCocktailApi {
    @GET("filter.php?a=Alcoholic")
    suspend fun getCocktail(): Response<DrinkList>
}