package com.example.tpfinal.bo

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    var id : Long,
    var name : String,
    var image : String,
    @Ignore
    var stats : PokemonStat
){
    constructor(id: Long, name: String, image: String, hp: Int, attack: Int, defense: Int, speed: Int)
            : this(id, name, image, PokemonStat(hp, attack, defense, speed))

    constructor() : this(0, "", "", PokemonStat(0, 0, 0, 0))

}

data class PokemonStat(
    @Json(name = "HP")
    var hp : Int,
    var attack : Int,
    var defense : Int,
    var speed : Int
)

