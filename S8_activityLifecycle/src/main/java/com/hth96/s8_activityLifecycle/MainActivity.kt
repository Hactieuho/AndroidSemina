package com.hth96.s8_activityLifecycle

import android.content.Intent
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
        viewModel.addText("1. onCreate")

        setOnClickListener()
        observeLiveData()
    }

    private fun setOnClickListener() {
        binding.btnStartOtherActivity.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OtherActivity::class.java
                )
            )
        }

        binding.btnBack.setOnClickListener {
            finish()
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

    override fun onStart() {
        super.onStart()
        viewModel.addText("2. onStart")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.addText("2.1. onRestoreInstanceState")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        viewModel.addText("3. onPostCreate")
    }

    override fun onResume() {
        super.onResume()
        viewModel.addText("4. onResume")
    }

    override fun onPostResume() {
        super.onPostResume()
        viewModel.addText("4.1 onPostResume")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.addText("4.2. onAttachedToWindow")
    }

    override fun onPause() {
        super.onPause()
        viewModel.addText("5. onPause")
    }

    override fun onStop() {
        super.onStop()
        viewModel.addText("6. onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.addText("6.1. onSaveInstanceState")
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.addText("6.2. onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.addText("7. onDestroy")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewModel.addText("7.1. onDetachedFromWindow")
    }
}