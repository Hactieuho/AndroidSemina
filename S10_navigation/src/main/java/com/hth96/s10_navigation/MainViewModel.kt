package com.hth96.s10_navigation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val textList = Repository.getInstance().textList

    val textStr = Transformations.map(textList) {
        it.joinToString(separator = "\n")
    }

    fun addText(text: String) {
        textList.value?.add(text)
        textList.postValue(textList.value)
    }

    fun clearTexts() {
        textList.postValue(ArrayList())
    }
}