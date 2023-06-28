package com.example.mod9tp1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod9room.db.AppDatabase
import com.example.mod9tp1.bo.Quality
import com.example.mod9tp1.dao.QualityDAO
import kotlinx.coroutines.launch

class QualityViewModel(private val qualityDAO: QualityDAO) : ViewModel() {


    var quality = MutableLiveData<List<Quality>>()

    fun addQuality(quality: Quality) : MutableLiveData<Long> {
        var id = MutableLiveData<Long>()
        viewModelScope.launch {
            id.value = qualityDAO.insert(quality)
        }
        return id
    }

    fun getQualities(){
        viewModelScope.launch {
            quality.value = qualityDAO.getAll()
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
                return QualityViewModel(
                    AppDatabase.getInstance(application.applicationContext).getQualityDAO()
                ) as T

            }
        }
    }




}