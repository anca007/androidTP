package com.example.tpfinal.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tpfinal.bo.Pokemon
import com.example.tpfinal.databinding.TemplatePokemonLineBinding
import com.squareup.picasso.Picasso

class PokemonAdapter(val lPoke : List<Pokemon>, val listener : (pokemon : Pokemon) -> Unit) : Adapter<PokemonAdapter.PokemonVH>() {

    class PokemonVH(val binding : TemplatePokemonLineBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVH {
        val binding = TemplatePokemonLineBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PokemonVH(binding)
    }

    override fun getItemCount(): Int {
        return lPoke.size
    }

    override fun onBindViewHolder(holder: PokemonVH, position: Int) {
        holder.binding.poke = lPoke[position]
        Picasso.get().load(lPoke[position].image).into(holder.binding.ivPokemon)
        //ajout d'évènements sur le bouton
        holder.itemView.setOnClickListener {
            listener.invoke(lPoke[position])
        }

    }

}