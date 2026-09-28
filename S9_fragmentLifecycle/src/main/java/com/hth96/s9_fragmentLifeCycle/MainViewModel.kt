package com.hth96.s9_fragmentLifeCycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel : ViewModel() {
    private val textList = Repository.getInstance().textList

    val textStr = textList.map {
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