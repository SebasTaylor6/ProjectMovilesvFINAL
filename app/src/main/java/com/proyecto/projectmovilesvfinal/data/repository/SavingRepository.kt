package com.proyecto.projectmovilesvfinal.data.repository

import com.proyecto.projectmovilesvfinal.data.dao.SavingDao
import com.proyecto.projectmovilesvfinal.data.model.Saving

class SavingRepository(private val savingDao: SavingDao) {

    suspend fun insertSaving(saving:Saving){
        savingDao.insertSaving(saving)
    }

    fun getSavings(id:Int):List<Saving>{
        return savingDao.getSavingsById(id)
    }

}