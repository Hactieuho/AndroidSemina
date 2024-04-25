package com.hth96.s10_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hth96.s9_fragmentLifeCycle.R
import com.hth96.s9_fragmentLifeCycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.addText("A1. onCreate, ${lifecycle.currentState}")

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnStartFragment1.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, Fragment1.newInstance())
            transaction.addToBackStack("fragment1")
            transaction.commit()
        }
        binding.btnStartFragment2.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, Fragment2.newInstance())
            transaction.addToBackStack("fragment2")
            transaction.commit()
        }
        binding.btnBack.setOnClickListener {
            supportFragmentManager.popBackStackImmediate()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.addText("A2. onStart, ${lifecycle.currentState}")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.addText("A2.1. onRestoreInstanceState, ${lifecycle.currentState}")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        viewModel.addText("A3. onPostCreate, ${lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        viewModel.addText("A4. onResume, ${lifecycle.currentState}")
    }

    override fun onPostResume() {
        super.onPostResume()
        viewModel.addText("A4.1 onPostResume, ${lifecycle.currentState}")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewModel.addText("A4.2. onAttachedToWindow, ${lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        viewModel.addText("A5. onPause, ${lifecycle.currentState}")
    }

    override fun onStop() {
        super.onStop()
        viewModel.addText("A6. onStop, ${lifecycle.currentState}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.addText("A6.1. onSaveInstanceState, ${lifecycle.currentState}")
    }

    override fun onRestart() {
        super.onRestart()
        viewModel.addText("A6.2. onRestart, ${lifecycle.currentState}")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.addText("A7. onDestroy, ${lifecycle.currentState}")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewModel.addText("A7.1. onDetachedFromWindow, ${lifecycle.currentState}")
    }
}