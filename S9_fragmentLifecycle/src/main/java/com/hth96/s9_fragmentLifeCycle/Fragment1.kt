package com.hth96.s9_fragmentLifeCycle

import android.content.Context
import android.os.Bundle
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
        viewModel.addText("F1. onAttach, ${lifecycle.currentState}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.addText("F2. onCreate, ${lifecycle.currentState}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel.addText("F3. onCreateView, ${lifecycle.currentState}")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment1, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.addText("F4. onViewCreated, ${lifecycle.currentState}")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        viewModel.addText("F4.1. onViewStateRestored, ${lifecycle.currentState}")
    }

    override fun onStart() {
        super.onStart()
        viewModel.addText("F5. onStart, ${lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        viewModel.addText("F6. onResume, ${lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        viewModel.addText("F7. onPause, ${lifecycle.currentState}")
    }

    override fun onStop() {
        super.onStop()
        viewModel.addText("F8. onStop, ${lifecycle.currentState}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.addText("F8.1. onSaveInstanceState, ${lifecycle.currentState}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.addText("F9. onDestroyView, ${lifecycle.currentState}")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.addText("F10. onDestroy, ${lifecycle.currentState}")
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.addText("F11. onDetach, ${lifecycle.currentState}")
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}