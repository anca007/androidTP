package com.example.mod9tp1bis.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mod9tp1bis.bo.AirQuality

@Dao
interface AirQualityDAO {

    @Insert
    suspend fun insert(airQuality: AirQuality) : Long

    @Query("SELECT * FROM AirQuality")
    suspend fun findAll() : List<AirQuality>


}