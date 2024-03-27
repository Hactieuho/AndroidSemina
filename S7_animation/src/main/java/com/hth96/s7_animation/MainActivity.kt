package com.hth96.s7_animation

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hth96.s7_animation.databinding.ActivityMainBinding


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
        binding.BTNblink.setOnClickListener {
            startAnimation(R.anim.blink)
        }
        binding.BTNfade.setOnClickListener {
            startAnimation(R.anim.fade)
        }
        binding.BTNmove.setOnClickListener {
            startAnimation(R.anim.move)
        }
        binding.BTNrotate.setOnClickListener {
            startAnimation(R.anim.rotate)
        }
        binding.BTNslide.setOnClickListener {
            startAnimation(R.anim.slide)
        }
        binding.BTNzoom.setOnClickListener {
            startAnimation(R.anim.zoom)
        }
        binding.BTNstop.setOnClickListener {
            binding.imageview.clearAnimation()
        }
    }

    private fun startAnimation(animationId: Int) {
        val animation = AnimationUtils.loadAnimation(applicationContext, animationId)
        binding.imageview.startAnimation(animation)
    }
}