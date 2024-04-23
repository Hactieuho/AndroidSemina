package com.hth96.s9_fragmentLifeCycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hth96.s9_fragmentLifeCycle.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    lateinit var binding: Fragment1Binding
    private val viewModel: MainViewModel = (activity as MainActivity).viewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment1, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.addText("2. onStart, ${lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        viewModel.addText("4. onResume, ${lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        viewModel.addText("5. onPause, ${lifecycle.currentState}")
    }

    override fun onStop() {
        super.onStop()
        viewModel.addText("6. onStop, ${lifecycle.currentState}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.addText("6.1. onSaveInstanceState, ${lifecycle.currentState}")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.addText("7. onDestroy, ${lifecycle.currentState}")
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}