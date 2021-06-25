package com.example.cocktailrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.example.cocktailrecipes.data.DrinkListRemoteEntity
import com.example.cocktailrecipes.network.CocktailService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var drinkName: TextView
    lateinit var drinkContainer: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drinkName = findViewById(R.id.drinkName)
        drinkContainer = findViewById(R.id.drinkContainer)

        getDrink()

        drinkContainer.setOnClickListener {
            getDrink()
        }
    }

    private fun getDrink() {
        lifecycleScope.launch {
            try {
                // 1.Executa requisicao
                val response = requestCocktails().drinks
                // 2. A partir de uma resposta escolher um drink aleatorio
                val drink = response.random()
                // 3. Colocar o nome do drink aleatório escolhido no textview
                drinkName.text = drink.strDrink
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun requestCocktails(): DrinkListRemoteEntity {
        return withContext(Dispatchers.IO) {
            CocktailService.service.getCocktail()
        }
    }
}