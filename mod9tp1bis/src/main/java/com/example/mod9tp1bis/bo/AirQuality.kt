package com.example.mod9tp1bis.bo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AirQuality(
    @PrimaryKey(true)
    val id : Long = 0,
    val name : String,
    val score : Float

)
