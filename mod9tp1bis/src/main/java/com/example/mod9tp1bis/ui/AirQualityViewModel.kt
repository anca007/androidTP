package com.example.mod9tp1bis.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod9tp1bis.bo.AirQuality
import com.example.mod9tp1bis.dao.AirQualityDAO
import com.example.mod9tp1bis.db.AppDatabase
import kotlinx.coroutines.launch

class AirQualityViewModel(private val airQualityDAO: AirQualityDAO) : ViewModel() {

    var airQualities = MutableLiveData<List<AirQuality>>()

    fun addQuality(airQuality: AirQuality) : MutableLiveData<Long> {
        var id = MutableLiveData<Long>()
        viewModelScope.launch {
            id.value = airQualityDAO.insert(airQuality)
        }
        return id
    }

    fun findAllQualities(){
        viewModelScope.launch {
            airQualities.value = airQualityDAO.findAll()
        }
    }

    companion object{

        val Factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {

                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])

                // instanciation du ViewModel en prenant en compte l'ajout de la dao
                //dans le constructeur
                return AirQualityViewModel(
                    AppDatabase.getInstance(application.applicationContext).getAirQualityDAO()
                ) as T

            }
        }
    }


}