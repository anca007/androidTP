package com.example.tpfinal.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.tpfinal.bo.Pokemon


@Dao
interface PokemonDAO {

    @Insert
    suspend fun insert(pokemon: Pokemon) : Long


}