package com.example.mod9tp1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mod9tp1.QualityViewModel
import com.example.mod9tp1.R
import com.example.mod9tp1.bo.Quality
import com.example.mod9tp1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val vm : QualityViewModel by viewModels() { QualityViewModel.Factory }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etCity = view.findViewById<EditText>(R.id.et_city)
        val rating = view.findViewById<RatingBar>(R.id.ratingBar)
        val button = view.findViewById<Button>(R.id.button)



        button.setOnClickListener {
            val quality = Quality(0, etCity.text.toString(), rating.rating)
            vm.addQuality(quality).observe(this){
                Log.i("sly", "onViewCreated: " + it)
            }
        }

    }


}