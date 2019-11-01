package com.example.kotlinwithjetpack.gaadi.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GaadiRepository @Inject constructor(dao: GaadiDao) {

    val getGaadiList = dao.getGaadiList()

}
