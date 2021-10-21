package com.hth96.s5_api.ui

import android.view.View
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hth96.s5_api.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val userRepository = UserRepository.instant

    val userList = Transformations.map(userRepository.getUsersResult) {
        it.data
    }

    val progressBarVisibility = Transformations.map(userRepository.getUsersResult) {
        if (it.isLoading()) View.VISIBLE else View.GONE
    }

    fun fetchUsers() = viewModelScope.launch(Dispatchers.IO) {
        userRepository.fetchUsers()
    }
}