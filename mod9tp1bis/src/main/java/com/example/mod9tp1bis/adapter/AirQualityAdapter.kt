package com.example.mod9tp1bis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mod9tp1bis.bo.AirQuality
import com.example.mod9tp1bis.databinding.TemplateAirQualityLineBinding

class AirQualityAdapter(val lAirQuality : List<AirQuality>) : Adapter<AirQualityAdapter.AirQualityVH>() {

    class AirQualityVH(val binding : TemplateAirQualityLineBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AirQualityVH {
        val binding = TemplateAirQualityLineBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AirQualityVH(binding)
    }

    override fun getItemCount(): Int {
        return lAirQuality.size
    }

    override fun onBindViewHolder(holder: AirQualityVH, position: Int) {
        holder.binding.aq = lAirQuality[position]
    }

}