package com.hth96.s3_twowaysbinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
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