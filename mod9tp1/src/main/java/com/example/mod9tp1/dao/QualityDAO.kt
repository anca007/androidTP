package com.example.mod9tp1.dao

import androidx.room.*
import com.example.mod9tp1.bo.Quality


@Dao
interface QualityDAO {

    @Insert
    suspend fun insert(quality: Quality) : Long


    @Query("SELECT * FROM Quality")
    suspend fun getAll() : List<Quality>

}