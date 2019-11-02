package com.example.kotlinwithjetpack.gaadi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.kotlinwithjetpack.R
import com.example.kotlinwithjetpack.databinding.FragmentMyGaadiListBinding
import com.example.kotlinwithjetpack.di.Injectable
import com.example.kotlinwithjetpack.di.injectViewModel
import com.example.kotlinwithjetpack.ui.VerticalItemDecoration
import com.example.kotlinwithjetpack.ui.hide
import javax.inject.Inject

class MyGaadiListFragment : Fragment(), Injectable {

    private lateinit var binding: FragmentMyGaadiListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: GaadiViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        viewModel = injectViewModel(viewModelFactory)

        binding = FragmentMyGaadiListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = GaadiListAdapter("local")
        binding.gaadiRecyclerView.addItemDecoration(
                VerticalItemDecoration(resources.getDimension(R.dimen.margin_normal).toInt(), true))
        binding.gaadiRecyclerView.adapter = adapter

        subscribeUi(binding, adapter)

        binding.fabAddNewGaadi.setOnClickListener {
            val direction = MyGaadiListFragmentDirections.actionMyAdFragmentToAddNewGaadiFragment()
            findNavController().navigate(direction)

        }

        return binding.root
    }

    private fun subscribeUi(binding: FragmentMyGaadiListBinding, adapter: GaadiListAdapter) {
        viewModel.myGaadi.observe(viewLifecycleOwner) { result ->
            binding.progressBar.hide()
            adapter.submitList(result)
        }
    }


}