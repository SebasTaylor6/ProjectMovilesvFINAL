package com.proyecto.projectmovilesvfinal.data.database

import android.content.Context
import androidx.room.*
import com.proyecto.projectmovilesvfinal.data.dao.LoanDao
import com.proyecto.projectmovilesvfinal.data.dao.SavingDao
import com.proyecto.projectmovilesvfinal.data.model.Client
import com.proyecto.projectmovilesvfinal.data.dao.ClientDao
import com.proyecto.proyectomovilesv2.data.dao.UserDao
import com.proyecto.projectmovilesvfinal.data.model.Loan
import com.proyecto.projectmovilesvfinal.data.model.Saving
import com.proyecto.proyectomovilesv2.data.model.User
import com.proyecto.proyectomovilesv2.data.utils.Converters

@Database(entities = [User:: class, Client::class, Loan::class, Saving::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MainDatabase :RoomDatabase(){

    abstract fun userDao(): UserDao
    abstract fun clientDao(): ClientDao
    abstract fun loanDao(): LoanDao
    abstract fun savingDao(): SavingDao

    companion object{

        @Volatile
        private var INSTANCE : MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "movdb"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}