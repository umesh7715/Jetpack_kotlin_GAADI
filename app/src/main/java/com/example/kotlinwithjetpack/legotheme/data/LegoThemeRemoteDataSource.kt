package com.example.kotlinwithjetpack.legotheme.data

import com.example.kotlinwithjetpack.api.BaseDataSource
import com.example.kotlinwithjetpack.api.LegoService
import javax.inject.Inject

/**
 * Works with the Lego API to get data.
 */
class LegoThemeRemoteDataSource @Inject constructor(private val service: LegoService) : BaseDataSource() {

    suspend fun fetchData() = getResult { service.getThemes(1, 1000, "-id") }

}
