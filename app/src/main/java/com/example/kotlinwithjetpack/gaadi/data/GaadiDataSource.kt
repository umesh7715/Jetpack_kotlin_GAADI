package com.example.kotlinwithjetpack.gaadi.data

import com.example.kotlinwithjetpack.api.BaseDataSource
import javax.inject.Inject

class GaadiDataSource @Inject constructor() : BaseDataSource() {

    //suspend fun fetchData() = getResult { service.getThemes(1, 1000, "-id") }
}
