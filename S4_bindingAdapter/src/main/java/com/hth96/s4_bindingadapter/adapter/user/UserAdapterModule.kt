package com.hth96.s4_bindingadapter.adapter.user

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.hth96.s4_bindingadapter.model.User

@BindingAdapter("app:userAvatar")
fun AppCompatImageView.userAvatar(url: String?) {
    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()
    Glide.with(context)
        .load(url)
        .placeholder(circularProgressDrawable)
        .into(this)
}

@BindingAdapter("app:userAdapter", "app:userList")
fun RecyclerView.userAdapter(userAdapter: UserAdapter?, userList: List<User>?) {
    if (adapter == null) {
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager = linearLayoutManager
        adapter = userAdapter
    }
    if (userAdapter?.currentList != userList) {
        userAdapter?.submitList(userList)
    }
}