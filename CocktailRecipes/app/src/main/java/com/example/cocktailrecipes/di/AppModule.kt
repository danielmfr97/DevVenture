package com.example.cocktailrecipes.di

import com.example.cocktailrecipes.data.db.CocktailDatabase
import com.example.cocktailrecipes.data.repository.DrinkRepository
import com.example.cocktailrecipes.presentation.DrinkViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    val module = module {
        factory {
            DrinkRepository(get())
        }
        single {
            CocktailDatabase.getDatabase(context = get())
        }
        single {
            get<CocktailDatabase>().drinksDao()
        }
        viewModel{
            DrinkViewModel(get())
        }
    }

}