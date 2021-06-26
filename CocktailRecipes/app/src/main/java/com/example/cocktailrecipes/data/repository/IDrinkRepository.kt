package com.example.cocktailrecipes.data.repository

import com.example.cocktailrecipes.data.model.Drink

interface IDrinkRepository {
    suspend fun getAllDrinks(): List<Drink>?

    suspend fun getDrinksFromDB(): List<Drink>?

    suspend fun getDrinksFromAPI(): List<Drink>?
}