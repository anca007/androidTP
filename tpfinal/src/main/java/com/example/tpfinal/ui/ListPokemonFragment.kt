package com.example.tpfinal.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tpfinal.R
import com.example.tpfinal.adapter.PokemonAdapter


class ListPokemonFragment : Fragment() {

    val vm : PokemonViewModel by viewModels { PokemonViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_pokemon, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        vm.getPokemons()

        vm.pokemons.observe(this){
            recycler.adapter = PokemonAdapter(it){
                val direction  = ListPokemonFragmentDirections.actionListToDetail(it.id)
                Navigation.findNavController(view).navigate(direction)
            }
            recycler.layoutManager = LinearLayoutManager(view.context)
        }


    }



}