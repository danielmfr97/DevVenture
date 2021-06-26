package com.example.cocktailrecipes.data.db

import androidx.room.Dao
import androidx.room.Query
import com.example.cocktailrecipes.data.model.Drink

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drinks_entity")
    suspend fun getAllDrinks(): List<Drink>
}