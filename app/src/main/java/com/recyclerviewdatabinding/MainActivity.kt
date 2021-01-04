package com.recyclerviewdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.recyclerviewdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val itemList: ArrayList<MyItem> = ArrayList()
        val myItemAdapter = MyItemAdapter(itemList)
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = manager
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.recyclerView.adapter = myItemAdapter
        binding.viewmodel = viewModel

        viewModel.itemList.observe(this) {
            itemList.clear()
            itemList.addAll(it)
            myItemAdapter.notifyItemInserted(itemList.size - 1)
            binding.recyclerView.smoothScrollToPosition(itemList.size - 1)
        }
    }
}