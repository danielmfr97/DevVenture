package com.example.cocktailrecipes

import android.app.Application
import com.example.cocktailrecipes.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CocktailApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CocktailApplication)
            modules(modules = AppModule.module)
        }
    }
}