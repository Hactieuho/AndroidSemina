package com.hth96.s5_api.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hth96.s5_api.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val userRepository = UserRepository.instant

    val searchText = MutableLiveData("")

    val userList = Transformations.switchMap(searchText) { search ->
        Transformations.map(userRepository.getUsersResult) { list ->
            list.data?.filter { it?.fullName()?.contains(search, true) == true }
        }
    }

    val progressBarVisibility = Transformations.map(userRepository.getUsersResult) {
        if (it.isLoading()) View.VISIBLE else View.GONE
    }

    fun fetchUsers() = viewModelScope.launch(Dispatchers.IO) {
        userRepository.fetchUsers()
    }
}