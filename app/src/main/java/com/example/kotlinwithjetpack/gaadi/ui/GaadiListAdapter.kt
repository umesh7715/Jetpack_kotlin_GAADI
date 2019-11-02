package com.example.kotlinwithjetpack.gaadi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinwithjetpack.databinding.ListItemGaadiBinding
import com.example.kotlinwithjetpack.gaadi.data.Gaadi


class GaadiListAdapter(private val fromFragment: String) : ListAdapter<Gaadi, GaadiListAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gaadi = getItem(position)
        holder.apply {
            bind(createOnClickListener(gaadi), gaadi)
            itemView.tag = gaadi
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemGaadiBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(gaadi: Gaadi): View.OnClickListener {
        return View.OnClickListener {

            var direction: NavDirections = if (fromFragment == "global") {
                GaadiListFragmentDirections.actionGaadiListFragmentToGaadiDetailFragment(gaadi)
            } else {
                MyGaadiListFragmentDirections.actionMyAdFragmentToGaadiDetailFragment(gaadi)
            }
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
            private val binding: ListItemGaadiBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Gaadi) {
            binding.apply {
                clickListener = listener
                gaadi = item
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Gaadi>() {

    override fun areItemsTheSame(oldItem: Gaadi, newItem: Gaadi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Gaadi, newItem: Gaadi): Boolean {
        return oldItem == newItem
    }
}