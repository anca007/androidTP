package com.example.tpfinal.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.tpfinal.R
import com.example.tpfinal.bo.Pokemon
import com.example.tpfinal.databinding.FragmentDetailPokemonBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso


class DetailPokemonFragment : Fragment() {

    val vm : PokemonViewModel by viewModels { PokemonViewModel.Factory }
    lateinit var binding: FragmentDetailPokemonBinding
    val args: DetailPokemonFragmentArgs by navArgs()
    lateinit var pokemon : Pokemon

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail_pokemon, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getPokemonById(args.pokemonId).observe(this) {
            Picasso.get().load(it.image).into(binding.imageView)
            binding.poke = it
            pokemon = it
        }

        binding.button.setOnClickListener {
            vm.addPokemon(pokemon).observe(this){
                Snackbar.make(view, pokemon.name + " saved !", Toast.LENGTH_LONG).show()
            }

        }


    }

}