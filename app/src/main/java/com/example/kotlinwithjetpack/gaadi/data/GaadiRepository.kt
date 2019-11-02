package com.example.kotlinwithjetpack.gaadi.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GaadiRepository @Inject constructor(private val dao: GaadiDao) {

    val getGaadiList = dao.getGaadiList()

    val getMyGaadiList = dao.getMyGaadiList()

    suspend fun saveGaadi(gaadi: Gaadi) {
        dao.saveGaadi(gaadi)
    }


}
