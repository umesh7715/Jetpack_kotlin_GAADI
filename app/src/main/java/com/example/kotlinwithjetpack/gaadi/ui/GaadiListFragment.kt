package com.example.kotlinwithjetpack.gaadi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.kotlinwithjetpack.R
import com.example.kotlinwithjetpack.databinding.FragmentGaadiListBinding
import com.example.kotlinwithjetpack.di.Injectable
import com.example.kotlinwithjetpack.di.injectViewModel
import com.example.kotlinwithjetpack.ui.VerticalItemDecoration
import com.example.kotlinwithjetpack.ui.hide
import javax.inject.Inject

class GaadiListFragment : Fragment(), Injectable {

    private lateinit var binding: FragmentGaadiListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: GaadiViewModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        viewModel = injectViewModel(viewModelFactory)

        binding = FragmentGaadiListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = GaadiListAdapter()
        binding.gaadiRecyclerView.addItemDecoration(
                VerticalItemDecoration(resources.getDimension(R.dimen.margin_normal).toInt(), true))
        binding.gaadiRecyclerView.adapter = adapter

        subscribeUi(binding, adapter)

        return binding.root
    }

    private fun subscribeUi(binding: FragmentGaadiListBinding, adapter: GaadiListAdapter) {
        viewModel.gaadi.observe(viewLifecycleOwner) { result ->
            binding.progressBar.hide()
            adapter.submitList(result)
        }
    }


}
