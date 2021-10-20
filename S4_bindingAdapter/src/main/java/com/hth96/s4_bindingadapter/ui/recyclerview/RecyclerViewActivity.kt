package com.hth96.s4_bindingadapter.ui.recyclerview

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hth96.s4_bindingadapter.R
import com.hth96.s4_bindingadapter.adapter.user.UserAdapter
import com.hth96.s4_bindingadapter.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecyclerViewBinding
    private val viewModel by viewModels<RecyclerViewViewModel>()
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)
        binding.viewModel = viewModel
        userAdapter = UserAdapter(this).also { binding.adapter = it }
        binding.lifecycleOwner = this
    }
}