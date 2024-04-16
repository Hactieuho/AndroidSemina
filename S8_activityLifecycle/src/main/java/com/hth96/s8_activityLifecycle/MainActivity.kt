package com.hth96.s8_activityLifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hth96.s8_activityLifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.addText("onCreate")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        viewModel.addText("onPostCreate")
    }

    override fun onStart() {
        super.onStart()
        viewModel.addText("onStart")
    }

    override fun onResume() {
        super.onResume()
        viewModel.addText("onResume")
    }

    override fun onPostResume() {
        super.onPostResume()
        viewModel.addText("onPostResume")
    }
}