package com.hth96.s6_customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hth96.s6_customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.happyButton.setOnClickListener {
            if (binding.happyButton.happinessState == EmotionalFaceView.HAPPY) {
                binding.happyButton.happinessState = EmotionalFaceView.SAD
            } else {
                binding.happyButton.happinessState = EmotionalFaceView.HAPPY
            }
        }

        binding.sadButton.setOnClickListener {
            if (binding.sadButton.happinessState == EmotionalFaceView.HAPPY) {
                binding.sadButton.happinessState = EmotionalFaceView.SAD
            } else {
                binding.sadButton.happinessState = EmotionalFaceView.HAPPY
            }
        }

        binding.emotionalFaceView.setOnClickListener {
            if (binding.emotionalFaceView.happinessState == EmotionalFaceView.HAPPY) {
                binding.emotionalFaceView.happinessState = EmotionalFaceView.SAD
            } else {
                binding.emotionalFaceView.happinessState = EmotionalFaceView.HAPPY
            }
        }
    }
}