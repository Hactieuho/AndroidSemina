package com.hth96.s10_navigation

import androidx.lifecycle.MutableLiveData

class Repository  private constructor() {
    val textList = MutableLiveData<ArrayList<String>>(ArrayList())

    private object Holder { val INSTANCE = Repository() }

    companion object {
        @JvmStatic
        fun getInstance(): Repository {
            return Holder.INSTANCE
        }
    }
}