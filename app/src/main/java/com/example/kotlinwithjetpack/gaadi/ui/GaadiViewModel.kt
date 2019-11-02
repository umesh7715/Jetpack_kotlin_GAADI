package com.example.kotlinwithjetpack.gaadi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinwithjetpack.gaadi.data.Gaadi
import com.example.kotlinwithjetpack.gaadi.data.GaadiRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class GaadiViewModel @Inject constructor(private val repository: GaadiRepository) : ViewModel() {

    val gaadi: LiveData<List<Gaadi>> = repository.getGaadiList

    val myGaadi: LiveData<List<Gaadi>> = repository.getMyGaadiList

    val saveGaadi = fun (gaadi: Gaadi) {
        viewModelScope.launch {
            repository.saveGaadi(gaadi)
        }
    }


}
