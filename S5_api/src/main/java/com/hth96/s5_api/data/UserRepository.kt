package com.hth96.s5_api.data

import androidx.lifecycle.MutableLiveData
import com.hth96.mvvmjetpack.resource.Resource
import com.hth96.s5_api.api.UserService
import com.hth96.s5_api.model.User
import com.hth96.s5_api.util.handleError

class UserRepository {

    private val userService = UserService.api

    // Lay danh sach user
    val getUsersResult = MutableLiveData<Resource<List<User?>?>>()

    // Get user list
    suspend fun fetchUsers() {
        getUsersResult.postValue(Resource.Loading("Getting user list", getUsersResult.value?.data))
        try {
            val result = userService.getUsers()
            if (result.isSuccessful && !result.body()?.data.isNullOrEmpty()) {
                // Luu lai danh sach user list
                getUsersResult.postValue(Resource.Success(result.body()?.data))
            } else {
                handleError(getUsersResult, "No user founds!")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            handleError(getUsersResult, "Getting user error: ${e.message}")
        }
    }

    companion object {
        val instant = UserRepository()
    }
}