package com.example.cocktailrecipes.data

import com.google.gson.annotations.SerializedName

data class DrinkRemoteEntity(
    @SerializedName("idDrink")
    val id: String,
    val strDrink: String,
    val strDrinkThumb: String)