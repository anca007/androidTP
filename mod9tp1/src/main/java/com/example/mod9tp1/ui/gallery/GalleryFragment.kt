package com.example.mod9tp1.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mod9tp1.QualityViewModel
import com.example.mod9tp1.R
import com.example.mod9tp1.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {


    private val vm : QualityViewModel by viewModels { QualityViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        vm.getQualities()
        vm.quality.observe(this){


            it.forEach {
                Log.i("Sly", it.toString())
            }
        }

    }


}