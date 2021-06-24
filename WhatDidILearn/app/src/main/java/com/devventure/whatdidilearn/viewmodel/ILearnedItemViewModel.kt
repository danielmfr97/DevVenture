package com.devventure.whatdidilearn.viewmodel

import com.devventure.whatdidilearn.entities.LearnedItem

interface ILearnedItemViewModel {

    fun insertItem(learnedItem: LearnedItem)
}