package com.devventure.whatdidilearn.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devventure.whatdidilearn.view.adapters.UnderstandingLevel

@Entity(tableName = "learned_item")
data class LearnedItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    val id: Int = 0,
    @ColumnInfo(name = "item_title")
    val name: String,
    @ColumnInfo(name = "item_description")
    val description: String,
    @ColumnInfo(name = "item_level")
    val understandingLevel: UnderstandingLevel
)
