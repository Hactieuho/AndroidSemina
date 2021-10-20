package com.hth96.s4_bindingadapter.ui.recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hth96.s4_bindingadapter.util.BindingAdapterUtil.dummyUserList

class RecyclerViewViewModel : ViewModel() {
    val userList = MutableLiveData(dummyUserList())
}