package com.hth96.s8_activityLifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.hth96.s8_activityLifecycle.databinding.ActivityOtherBinding

class OtherActivity : AppCompatActivity() {
    private val viewModel by viewModels<OtherViewModel>()

    private val binding: ActivityOtherBinding by lazy {
        DataBindingUtil.setContentView<ActivityOtherBinding?>(
            this,
            R.layout.activity_other
        ).apply {
            lifecycleOwner = this@OtherActivity
            viewModel = this@OtherActivity.viewModel
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnClickListener()
    }


    private fun setOnClickListener() {
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnFinishMainActivity.setOnClickListener {
            Repository.getInstance().triggerFinishMainActivity.postValue(true)
        }

        binding.btnStartMainActivity.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )
        }
    }
}