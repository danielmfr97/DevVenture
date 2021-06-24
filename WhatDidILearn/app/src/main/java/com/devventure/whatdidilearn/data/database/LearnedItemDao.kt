package com.devventure.whatdidilearn.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devventure.whatdidilearn.entities.LearnedItem
import java.util.*

@Dao
interface LearnedItemDao {

    @Query("SELECT * FROM learned_item ORDER BY item_title ASC")
    fun getAll(): LiveData<List<LearnedItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(learnedItem: LearnedItem)


}