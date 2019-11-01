package com.example.kotlinwithjetpack.gaadi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinwithjetpack.R
import com.example.kotlinwithjetpack.databinding.FragmentGaadiDetailBinding
import com.example.kotlinwithjetpack.di.Injectable
import com.example.kotlinwithjetpack.gaadi.data.Gaadi
import com.example.kotlinwithjetpack.ui.VerticalItemDecoration

class GaadiDetailFragment : Fragment(), Injectable {

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var binding: FragmentGaadiDetailBinding
    private val args: GaadiDetailFragmentArgs by navArgs()
    private lateinit var gaadi: Gaadi


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentGaadiDetailBinding.inflate(inflater, container, false)

        context ?: return binding.root

        linearLayoutManager = LinearLayoutManager(activity)
        gaadi = args.gaadiDetails

        binding.gaadi = gaadi

        val adapter = GaadiDetailsImageAdapter()
        binding.gaadiDetailRecyclerView.addItemDecoration(
                VerticalItemDecoration(resources.getDimension(R.dimen.margin_normal).toInt(), true))
        binding.gaadiDetailRecyclerView.adapter = adapter

        binding.floatingActionButton.setOnClickListener {
            val direction = GaadiDetailFragmentDirections.actionGaadiDetailFragmentToContactFragment()
            it.findNavController().navigate(direction)
        }

        adapter.submitList(gaadi.images)

        return binding.root
    }


}