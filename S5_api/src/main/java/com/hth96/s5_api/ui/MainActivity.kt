package com.hth96.s5_api.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hth96.s5_api.R
import com.hth96.s5_api.adapter.user.UserAdapter
import com.hth96.s5_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initUI()
        observeViewModel()
    }

    private fun initUI() {
        userAdapter = UserAdapter(this).also { binding.adapter = it }
        viewModel.fetchUsers()
    }

    private fun observeViewModel() {
        binding.viewModel = viewModel
        binding.adapter = userAdapter
        binding.lifecycleOwner = this
    }
}