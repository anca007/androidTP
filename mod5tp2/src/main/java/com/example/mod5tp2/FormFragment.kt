package com.example.mod5tp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.mod5tp2.databinding.FragmentFormBinding

class FormFragment : Fragment() {

    lateinit var binding : FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_form, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val firstname : String = binding.etFirstname.text.toString()
            val place : String = binding.etPlace.text.toString()
            val story = Story(firstname, place)

            //prépare les données à envoyer au fragment
            val direction = FormFragmentDirections.actionFormToStory(story)
            //déclenche le passage au fragment suivant
            Navigation.findNavController(view).navigate(direction)

        }
    }


}