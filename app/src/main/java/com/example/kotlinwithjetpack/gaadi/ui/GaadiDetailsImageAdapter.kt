package com.example.kotlinwithjetpack.gaadi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwithjetpack.databinding.ListItemGaadiDetailsImageBinding

class GaadiDetailsImageAdapter : ListAdapter<String, GaadiDetailsImageAdapter.ViewHolder>(GaadiImageDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gaadi = getItem(position)
        holder.apply {
            bind(gaadi)
            itemView.tag = gaadi
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemGaadiDetailsImageBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }


    class ViewHolder(
            private val binding: ListItemGaadiDetailsImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.apply {
                imageUrl = item
                executePendingBindings()
            }
        }
    }
}

private class GaadiImageDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem.equals(newItem)
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}

