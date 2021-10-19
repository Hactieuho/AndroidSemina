package com.hth96.s4_bindingadapter.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.hth96.s4_bindingadapter.R

@BindingAdapter("app:favouriteColor")
fun AppCompatImageView.favouriteColor(favouriteColorCheckedButtonId: Int) {
    when (favouriteColorCheckedButtonId) {
        R.id.rb_red -> setBackgroundResource(R.color.red)
        R.id.rb_green -> setBackgroundResource(R.color.green)
        R.id.rb_blue -> setBackgroundResource(R.color.blue)
        else -> setBackgroundResource(R.color.grey)
    }
}