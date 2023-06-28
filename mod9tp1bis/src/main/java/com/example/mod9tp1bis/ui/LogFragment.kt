package com.example.mod9tp1bis.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import com.example.mod9tp1bis.R


class LogFragment : Fragment() {

    val vm : AirQualityViewModel by viewModels { AirQualityViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonLog = view.findViewById<Button>(R.id.buttonLog)

        buttonLog.setOnClickListener {
            vm.findAllQualities()

            vm.airQualities.observe(this){
                it.forEach {
                    airQuality -> Log.i("sly", airQuality.toString())
                }
            }

        }

    }


}