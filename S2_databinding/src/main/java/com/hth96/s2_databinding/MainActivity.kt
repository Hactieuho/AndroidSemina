package com.hth96.s2_databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hth96.s2_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var value = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.tvValue.text = "Your value is $value"
        binding.btnPlus.setOnClickListener {
            value++
            binding.tvValue.text = "Your value is $value"
        }
        binding.btnMinus.setOnClickListener {
            value--
            binding.tvValue.text = "Your value is $value"
        }
    }
}