package com.example.cocktailrecipes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cocktailrecipes.data.model.Drink

@Database(
    entities = [Drink::class],
    version = 1,
    exportSchema = false
)
abstract class CocktailDatabase : RoomDatabase() {
    abstract fun drinksDao(): DrinkDao

    companion object {
        @Volatile // Torna esse campo imediatamente visivel apra outras threads
        private var INSTANCE: CocktailDatabase? = null

        // Usamos o synchronized para garantir que a criação só seja disparada uma vez por solicitação
        fun getDatabase(context: Context): CocktailDatabase {
            return INSTANCE ?: synchronized(this) {
                val database = Room.databaseBuilder(
                    context.applicationContext,
                    CocktailDatabase::class.java,
                    "cocktail_database"
                )
                    .build()
                INSTANCE = database
                database
            }
        }
    }

}