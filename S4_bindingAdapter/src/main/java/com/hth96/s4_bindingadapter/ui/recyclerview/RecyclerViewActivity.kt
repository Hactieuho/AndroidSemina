package com.hth96.s4_bindingadapter.ui.recyclerview

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hth96.s4_bindingadapter.adapter.user.UserAdapter
import com.hth96.s4_bindingadapter.databinding.ActivityRecyclerViewBinding
import com.hth96.s4_bindingadapter.R
import android.view.Menu

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var binding: ActivityRecyclerViewBinding
    private val viewModel by viewModels<RecyclerViewViewModel>()
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view)
        binding.viewModel = viewModel
        userAdapter = UserAdapter(this) {
            viewModel.deleteUser(it)
        }.also { binding.adapter = it }
        binding.lifecycleOwner = this
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_add -> {
            viewModel.addUser()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}