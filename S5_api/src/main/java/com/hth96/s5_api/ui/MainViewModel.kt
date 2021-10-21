package com.hth96.s5_api.ui

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

    fun fetchUsers() = viewModelScope.launch(Dispatchers.IO) {
        userRepository.fetchUsers()
    }
}