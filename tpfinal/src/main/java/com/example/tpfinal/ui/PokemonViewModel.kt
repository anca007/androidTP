package com.example.tpfinal.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.tpfinal.bo.Pokemon
import com.example.tpfinal.dao.PokemonDAO
import com.example.tpfinal.db.AppDatabase
import com.example.tpfinal.service.PokemonApi
import com.example.tpfinal.service.PokemonService
import kotlinx.coroutines.launch

class PokemonViewModel(private val pokemonDAO: PokemonDAO) : ViewModel() {

    var pokemons = MutableLiveData<List<Pokemon>>()


    fun getPokemons(){
        viewModelScope.launch {
            pokemons.value = PokemonApi.retrofitService.findAll()
        }
    }

    fun getPokemonById(id : Long): MutableLiveData<Pokemon> {
        var pokemon = MutableLiveData<Pokemon>()
        viewModelScope.launch {
            pokemon.value = PokemonApi.retrofitService.findById(id)
        }
        return pokemon
    }

    fun addPokemon(pokemon: Pokemon): MutableLiveData<Pokemon> {
        var id = MutableLiveData<Pokemon>()
        viewModelScope.launch {
            pokemonDAO.insert(pokemon)
        }
        return id
    }

    companion object{

        val Factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {

                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])

                // instanciation du ViewModel en prenant en compte l'ajout de la dao
                //dans le constructeur
                return PokemonViewModel(
                    AppDatabase.getInstance(application.applicationContext).getPokemonDAO()
                ) as T

            }
        }
    }
}