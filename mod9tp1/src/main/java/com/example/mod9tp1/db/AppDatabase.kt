package com.example.mod9room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mod9tp1.bo.Quality
import com.example.mod9tp1.dao.QualityDAO

@Database(entities = [Quality::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //liste de mes DAO
    abstract fun getQualityDAO() : QualityDAO

    companion object{
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase {
            var instance = INSTANCE

            if(instance == null){

                //DatabaseBuilder permet de construire des objets complexe
                //à partir d'un moule de base, j'appelle ensuite des méthodes
                //pour ajouter des éléments à mon objet
                instance = Room.databaseBuilder(
                    //permet de récupérer le package name de l'application
                    //pour ranger correctement la base
                    context,
                    //Type de BDD à construire
                    AppDatabase::class.java,
                    //Nom donné à la BDD
                    "Q"
                //Permet de supprimer l'ancienne BDD lors de changement de version
                ).fallbackToDestructiveMigration()
                     //build() permet de constuire l'objet final
                    .build()

                INSTANCE = instance
            }
            return instance
        }
    }

}