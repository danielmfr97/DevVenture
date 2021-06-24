package com.devventure.whatdidilearn.data

import androidx.lifecycle.LiveData
import com.devventure.whatdidilearn.data.database.LearnedItemDao
import com.devventure.whatdidilearn.entities.LearnedItem

class LearnedItemRepository(private val dao: LearnedItemDao) {
    val learnedItems: LiveData<List<LearnedItem>> = dao.getAll()

    fun addNewItem(item: LearnedItem) = dao.insert(item)
}