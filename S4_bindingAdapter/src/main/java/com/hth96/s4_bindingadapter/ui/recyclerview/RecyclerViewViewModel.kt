package com.hth96.s4_bindingadapter.ui.recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.hth96.s4_bindingadapter.model.User
import com.hth96.s4_bindingadapter.util.BindingAdapterUtil.dummyUserList
import kotlin.random.Random

class RecyclerViewViewModel : ViewModel() {
    val userList = MutableLiveData(dummyUserList())


    val searchText = MutableLiveData("")

    val filteredList = Transformations.switchMap(searchText) { search ->
        Transformations.map(userList) { list ->
            list?.filter { it.fullName().contains(search, true) ||  it.email?.contains(search, true) == true }
        }
    }

    fun addUser() {
        val result = userList.value?.also {
            val index = Random.nextInt(20, 100)
            it.add(0,
                User(
                    index.toLong(),
                    "Hactieuho$index@gmail.com",
                    "Le",
                    "Manh Hung",
                    "https://reqres.in/img/faces/7-image.jpg",
                )
            )
        }
        userList.postValue(result)
    }

    fun deleteUser(user: User) {
        val result = userList.value?.filter { it.id != user.id }
        userList.postValue(result as ArrayList<User>?)
    }
}