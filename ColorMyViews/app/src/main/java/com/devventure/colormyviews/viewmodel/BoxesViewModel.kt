package com.devventure.colormyviews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BoxesViewModel : ViewModel() {

    val mapBoxesColors: MutableLiveData<HashMap<Int, Int>> by lazy {
        MutableLiveData<HashMap<Int, Int>>()
    }

}