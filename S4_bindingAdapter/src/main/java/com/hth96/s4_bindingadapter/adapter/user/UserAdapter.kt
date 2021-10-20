package com.hth96.s4_bindingadapter.adapter.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hth96.s4_bindingadapter.adapter.viewholder.DataBindingViewHolder
import com.hth96.s4_bindingadapter.databinding.ItemUserBinding
import com.hth96.s4_bindingadapter.model.User

class UserAdapter(
    private val activity: AppCompatActivity
) : ListAdapter<User, DataBindingViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        return DataBindingViewHolder(
            ItemUserBinding.inflate(LayoutInflater.from(activity), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        val binding = holder.binding as ItemUserBinding
        binding.viewModel = getItem(position)
        binding.lifecycleOwner = activity
    }
}

private val DiffCallback = object : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
