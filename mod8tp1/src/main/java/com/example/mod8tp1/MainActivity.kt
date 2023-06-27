package com.example.mod8tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mod8tp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var vm : DiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        vm = ViewModelProvider(this)[DiceViewModel::class.java]

        binding.vm = vm

        binding.buttonLeft.setOnClickListener {
            vm.launchLeft()
            binding.vm = vm
        }

        binding.buttonRight.setOnClickListener {
            vm.launchRight()
            binding.vm = vm
        }

    }
}