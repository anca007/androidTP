package com.example.mod8tp1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {

    var totalLaunch = MutableLiveData(0)
    var totalLeft = 0
    var totalRight = 0
    var nbLaunchLeft = 0
    var nbLaunchRight = 0
    var imageId = R.drawable.d1
    var dice = 1

    private fun launchDice() : Int{
        totalLaunch.value = totalLaunch.value?.inc()
        dice = (1..6).random()

        imageId = when(dice){
            1 -> R.drawable.d1
            2 -> R.drawable.d2
            3 -> R.drawable.d3
            4 -> R.drawable.d4
            5 -> R.drawable.d5
            else -> R.drawable.d6
        }

        return dice
    }

    fun launchLeft(){
        nbLaunchLeft++
        totalLeft += launchDice()
    }

    fun launchRight(){
        nbLaunchRight++
        totalRight += launchDice()
    }
}