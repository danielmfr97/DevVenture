package com.example.cocktailrecipes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktailrecipes.data.model.Drink
import com.example.cocktailrecipes.data.repository.DrinkRepository
import kotlinx.coroutines.launch

class DrinkViewModel(private val repository: DrinkRepository) : ViewModel() {

    private var drinks: MutableLiveData<List<Drink>> = MutableLiveData()

    fun getDrinks(): LiveData<List<Drink>> {
        viewModelScope.launch {
            val result = repository.getAllDrinks()
            drinks.postValue(result)
        }
        return drinks
    }
}