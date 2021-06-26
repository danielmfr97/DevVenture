package com.example.cocktailrecipes.data.repository

import com.example.cocktailrecipes.data.db.DrinkDao
import com.example.cocktailrecipes.data.model.Drink

class DrinkRepository(private val dao: DrinkDao) : IDrinkRepository {
    override suspend fun getAllDrinks(): List<Drink> {
        return dao.getAllDrinks()
    }
}