package com.hth96.s8_activityLifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val textList = MutableLiveData<ArrayList<String>>(ArrayList())
    val textStr = Transformations.map(textList) {
        it.joinToString(separator = "\n")
    }

    fun addText(text: String) {
        textList.value?.add(text)
        textList.postValue(textList.value)
    }
}