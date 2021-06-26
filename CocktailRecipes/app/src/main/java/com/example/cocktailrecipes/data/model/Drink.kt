package com.example.cocktailrecipes.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "drinks_entity")
data class Drink(
    @SerializedName("idDrink")
    val id: String,
    val strDrink: String,
    val strDrinkThumb: String)