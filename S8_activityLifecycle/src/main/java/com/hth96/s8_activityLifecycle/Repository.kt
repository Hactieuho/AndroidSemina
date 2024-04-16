package com.hth96.s8_activityLifecycle

import androidx.lifecycle.MutableLiveData

class Repository  private constructor() {
    val textList = MutableLiveData<ArrayList<String>>(ArrayList())

    val triggerFinishMainActivity = MutableLiveData<Boolean?>(null)

    private object Holder { val INSTANCE = Repository() }

    companion object {
        @JvmStatic
        fun getInstance(): Repository{
            return Holder.INSTANCE
        }
    }
}