package com.hth96.s9_fragmentLifeCycle

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hth96.s9_fragmentLifeCycle.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    lateinit var binding: Fragment1Binding
    private val viewModel by lazy { (activity as MainActivity).viewModel }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.addText("1. onAttach, ${lifecycle.currentState}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.addText("2. onCreate, ${lifecycle.currentState}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.addText("3. onCreateView, ${lifecycle.currentState}")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment1, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.addText("4. onViewCreated, ${lifecycle.currentState}")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        viewModel.addText("4.1. onViewStateRestored, ${lifecycle.currentState}")
    }

    override fun onStart() {
        super.onStart()
        viewModel.addText("5. onStart, ${lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        viewModel.addText("6. onResume, ${lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        viewModel.addText("7. onPause, ${lifecycle.currentState}")
    }

    override fun onStop() {
        super.onStop()
        viewModel.addText("8. onStop, ${lifecycle.currentState}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.addText("8.1. onSaveInstanceState, ${lifecycle.currentState}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.addText("9. onDestroyView, ${lifecycle.currentState}")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.addText("10. onDestroy, ${lifecycle.currentState}")
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.addText("11. onDetach, ${lifecycle.currentState}")
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}