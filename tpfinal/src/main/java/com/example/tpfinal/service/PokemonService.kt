package com.example.tpfinal.service

import com.example.tpfinal.bo.Pokemon
import com.example.tpfinal.service.PokemonService.Companion.retrofit
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonService {

    companion object{

        var BASE_URL : String = "https://pokebuildapi.fr/api/v1/"

        //convertisseur intégré dans retrofit permet de transformer le JSON en objet et inversement
        var moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        //librairie qui permet de lancer nos appels aux API
        var retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @GET("pokemon")
    suspend fun findAll() : List<Pokemon>

    @GET("pokemon/{id}")
    suspend fun findById(@Path("id") id : Long) : Pokemon


}

object PokemonApi{
    //permet de renvoyer une instance d'un objet qui implémente l'interface
    //lazy permet d'initialiser la variable uniquement si je m'en sers
    val retrofitService : PokemonService by lazy { retrofit.create(PokemonService::class.java) }
}

