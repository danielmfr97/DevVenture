package com.devventure.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devventure.whatdidilearn.data.LearnedItemRepository
import java.lang.IllegalArgumentException

class LearnedItemViewModelFactory(private val repository: LearnedItemRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LearnedItemViewModel::class.java))
            return LearnedItemViewModel(repository) as T
        throw IllegalArgumentException("Unknown View Model Class")
    }
}