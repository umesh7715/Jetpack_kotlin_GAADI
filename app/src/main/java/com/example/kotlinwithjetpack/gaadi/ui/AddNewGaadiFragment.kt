package com.example.kotlinwithjetpack.gaadi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.kotlinwithjetpack.R
import com.example.kotlinwithjetpack.databinding.FragmentAddNewGaadiBinding
import com.example.kotlinwithjetpack.di.Injectable
import com.example.kotlinwithjetpack.di.injectViewModel
import com.example.kotlinwithjetpack.gaadi.data.Gaadi
import com.example.kotlinwithjetpack.ui.VerticalItemDecoration
import javax.inject.Inject

class AddNewGaadiFragment : Fragment(), Injectable {

    private lateinit var binding: FragmentAddNewGaadiBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: GaadiViewModel

    private lateinit var sellerDteials: String
    private lateinit var vehicleDetails: String
    private lateinit var vehicleName: String


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        viewModel = injectViewModel(viewModelFactory)

        binding = FragmentAddNewGaadiBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = GaadiDetailsImageAdapter()
        binding.rvMyGaadiListImages.addItemDecoration(
                VerticalItemDecoration(resources.getDimension(R.dimen.margin_normal).toInt(), true))
        binding.rvMyGaadiListImages.adapter = adapter

        binding.addPhotos.setOnClickListener {

            val action = AddNewGaadiFragmentDirections.actionAddNewGaadiFragmentToCameraFragment()
            findNavController().navigate(action)
        }

        binding.save.setOnClickListener {

            sellerDteials = binding.etSellerDetails.text.toString()
            vehicleDetails = binding.etVehicleDetails.text.toString()
            vehicleName = binding.etVehicleName.text.toString()



            if (vehicleName.isEmpty()) {
                Toast.makeText(context, "Vehicle name cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (sellerDteials.isEmpty()) {
                Toast.makeText(context, "Invalid email address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (vehicleDetails.isEmpty()) {
                Toast.makeText(context, "Password cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            viewModel.saveGaadi(Gaadi(null, vehicleName, sellerDteials, vehicleDetails, 1, listOf("https://www.trzcacak.rs/myfile/full/284-2847835_2019-toyota-tacoma-placeholder-car-png.png", "https://www.trzcacak.rs/myfile/full/284-2847835_2019-toyota-tacoma-placeholder-car-png.png")))
            findNavController().navigateUp()

        }

        return binding.root
    }

}