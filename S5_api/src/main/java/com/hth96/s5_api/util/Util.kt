package com.hth96.s5_api.util

import android.widget.Button
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.blankj.utilcode.util.ToastUtils
import com.hth96.mvvmjetpack.resource.Resource

@BindingAdapter("app:onClick", "app:key")
fun Button.onClick(check: (String?) -> Unit, key: String?) {
    setOnClickListener { check(key) }
}

fun<T: Any?> handleError(
    data: MutableLiveData<Resource<T>>,
    errorText: String) {
    ToastUtils.showShort(errorText)
    data.postValue(Resource.Error(errorText, data.value?.data))
}

fun<T: Any?> LifecycleOwner.handleError(result: MutableLiveData<Resource<T>>) {
    result.observe(this) {
        if (it is Resource.Error) {
            ToastUtils.showShort(it.message)
        }
    }
}