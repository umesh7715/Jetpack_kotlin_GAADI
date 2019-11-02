package com.example.kotlinwithjetpack.gaadi.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GaadiDao {

    @Query("SELECT * FROM gaadi ORDER BY id DESC")
    fun getGaadiList(): LiveData<List<Gaadi>>

    @Query("SELECT * FROM gaadi where isMyGaadi = 1 ORDER BY id DESC")
    fun getMyGaadiList(): LiveData<List<Gaadi>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(gaadiList: List<Gaadi>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveGaadi(gaadi: Gaadi)
}

