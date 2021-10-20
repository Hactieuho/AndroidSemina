package com.hth96.s4_bindingadapter.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hth96.s4_bindingadapter.R
import com.hth96.s4_bindingadapter.databinding.ActivityMainBinding
import com.hth96.s4_bindingadapter.ui.recyclerview.RecyclerViewActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.btnRecyclerView.setOnClickListener { startActivity(Intent(this, RecyclerViewActivity::class.java)) }
    }
}