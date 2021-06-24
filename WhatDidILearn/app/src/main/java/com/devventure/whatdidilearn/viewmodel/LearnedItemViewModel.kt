package com.devventure.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devventure.whatdidilearn.data.LearnedItemRepository
import com.devventure.whatdidilearn.entities.LearnedItem
import kotlinx.coroutines.launch

class LearnedItemViewModel(private val repository: LearnedItemRepository) : ViewModel(),
    ILearnedItemViewModel {
    val learnedItems: LiveData<List<LearnedItem>> = repository.learnedItems

    override fun insertItem(learnedItem: LearnedItem) {
        viewModelScope.launch {
            repository.addNewItem(learnedItem)
        }
    }
}