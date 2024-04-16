package com.hth96.s8_activityLifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class OtherViewModel : ViewModel() {
    private val textList = Repository.getInstance().textList

    val textStr = Transformations.map(textList) {
        it.joinToString(separator = "\n")
    }

    fun clearTexts() {
        textList.postValue(ArrayList())
    }
}