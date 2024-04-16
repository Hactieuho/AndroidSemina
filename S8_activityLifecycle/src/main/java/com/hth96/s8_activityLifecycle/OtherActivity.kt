package com.hth96.s8_activityLifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hth96.s8_activityLifecycle.databinding.ActivityOtherBinding

class OtherActivity : AppCompatActivity() {
    val binding: ActivityOtherBinding by lazy {
        DataBindingUtil.setContentView<ActivityOtherBinding?>(
            this,
            R.layout.activity_other
        ).apply { lifecycleOwner = this@OtherActivity }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnClickListener()
    }


    private fun setOnClickListener() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}