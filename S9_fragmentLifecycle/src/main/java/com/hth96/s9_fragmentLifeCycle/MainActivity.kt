package com.hth96.s9_fragmentLifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hth96.s9_fragmentLifeCycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setOnClickListener()
        observeLiveData()
    }

    private fun setOnClickListener() {
        binding.btnStartFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, Fragment1.newInstance())
                .commit()
        }
        binding.btnStartFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, Fragment2.newInstance())
                .commit()
        }
    }

    private fun observeLiveData() {
        Repository.getInstance().triggerFinishMainActivity.observe(this) {
            if (it == true) {
                Repository.getInstance().triggerFinishMainActivity.value = null
                finish()
            }
        }
    }
}