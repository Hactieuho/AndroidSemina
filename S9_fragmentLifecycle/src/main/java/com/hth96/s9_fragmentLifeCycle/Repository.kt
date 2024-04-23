package com.hth96.s9_fragmentLifeCycle

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