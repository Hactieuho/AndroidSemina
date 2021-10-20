package com.hth96.s4_bindingadapter.recyclerview

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.hth96.s4_bindingadapter.R

class RecyclerViewViewModel : ViewModel() {

    val firstName = MutableLiveData("")
    val lastNameVisibility = Transformations.map(firstName) {
        if (it.isNullOrBlank()) View.GONE else View.VISIBLE
    }
    val lastName = MutableLiveData("")
    val fullName = Transformations.switchMap(firstName) { first ->
        Transformations.map(lastName) { last ->
            "Your full name is: ${first.trim()} ${last.trim()}"
        }
    }
    val fullNameVisibility = Transformations.switchMap(firstName) { first ->
        Transformations.map(lastName) { last ->
            if (first.isNullOrBlank() || last.isNullOrBlank()) View.GONE else View.VISIBLE
        }
    }

    val favouriteColorCheckedButtonId = MutableLiveData(R.id.rb_green)
}