package com.devventure.whatdidilearn.data

import androidx.lifecycle.LiveData
import com.devventure.whatdidilearn.data.database.LearnedItemDao
import com.devventure.whatdidilearn.entities.LearnedItem
import java.util.*

class LearnedItemRepository(private val dao: LearnedItemDao) {
    val learnedItems: LiveData<List<LearnedItem>> = dao.getAll()

    suspend fun addNewItem(item: LearnedItem) {
        dao.insert(item)
    }
}