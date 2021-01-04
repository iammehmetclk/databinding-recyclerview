package com.recyclerviewdatabinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.recyclerviewdatabinding.databinding.MyItemLayoutBinding

class MyItemAdapter(private val itemList: List<MyItem>) : RecyclerView.Adapter<MyItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MyItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(private val binding: MyItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}