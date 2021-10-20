package com.hth96.s4_bindingadapter.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.hth96.s4_bindingadapter.R
import com.hth96.s4_bindingadapter.model.User

object BindingAdapterUtil {
    fun dummyUserList() : ArrayList<User> {
        val result = arrayListOf<User>()
        for (i in 1..20) {
            result.add(User(
                i.toLong(),
                "Hactieuho$i@gmail.com",
                "Le",
                "Manh Hung",
                "https://reqres.in/img/faces/7-image.jpg",
            ))
        }
        return result
    }
}

@BindingAdapter("app:favouriteColor")
fun AppCompatImageView.favouriteColor(favouriteColorCheckedButtonId: Int) {
    when (favouriteColorCheckedButtonId) {
        R.id.rb_red -> setBackgroundResource(R.color.red)
        R.id.rb_green -> setBackgroundResource(R.color.green)
        R.id.rb_blue -> setBackgroundResource(R.color.blue)
        else -> setBackgroundResource(R.color.grey)
    }
}