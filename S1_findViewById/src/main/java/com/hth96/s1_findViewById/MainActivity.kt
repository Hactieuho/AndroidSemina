package com.hth96.s1_findViewById

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {

    private var value = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvValue = findViewById<AppCompatTextView>(R.id.tv_value)
        val btnPlus = findViewById<AppCompatButton>(R.id.btn_plus)
        val btnMinus = findViewById<AppCompatButton>(R.id.btn_minus)

        tvValue.text = "Your value is $value"
        btnPlus.setOnClickListener {
            value++
            tvValue.text = "Your value is $value"
        }
        btnMinus.setOnClickListener {
            value--
            tvValue.text = "Your value is $value"
        }
    }
}