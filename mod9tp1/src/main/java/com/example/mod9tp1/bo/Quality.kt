package com.example.mod9tp1.bo


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Quality(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val name : String,
    val note : Float
)
