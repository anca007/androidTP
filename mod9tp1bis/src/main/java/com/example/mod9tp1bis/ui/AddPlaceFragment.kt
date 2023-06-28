package com.example.mod9tp1bis.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.mod9tp1bis.R
import com.example.mod9tp1bis.bo.AirQuality
import com.example.mod9tp1bis.databinding.FragmentAddPlaceBinding

class AddPlaceFragment : Fragment() {

    lateinit var binding: FragmentAddPlaceBinding
    val vm : AirQualityViewModel by viewModels { AirQualityViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_place, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val airQuality = AirQuality(0, binding.etPlace.text.toString(), binding.ratingBar.rating)
            vm.addQuality(airQuality).observe(this){
                Navigation.findNavController(view).navigate(R.id.actionPlaceToLog)
            }

        }

    }

}