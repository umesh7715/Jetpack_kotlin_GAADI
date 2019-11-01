package com.example.kotlinwithjetpack.gaadi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinwithjetpack.gaadi.data.Gaadi
import com.example.kotlinwithjetpack.gaadi.data.GaadiRepository
import javax.inject.Inject

class GaadiViewModel @Inject constructor(repository: GaadiRepository) : ViewModel() {

    val gaadi: LiveData<List<Gaadi>> = repository.getGaadiList
}
