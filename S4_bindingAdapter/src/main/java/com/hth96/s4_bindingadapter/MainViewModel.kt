package com.hth96.s4_bindingadapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val name = MutableLiveData("")
    val yourName = Transformations.map(name) {
        "Your name is $it"
    }

    private val value = MutableLiveData(10)
    val text = Transformations.map(value) {
        "Your value is $it"
    }

    fun minus() {
        value.postValue(value.value as Int - 1)
    }

    fun plus() {
        value.postValue(value.value as Int + 1)
    }
}