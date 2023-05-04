package com.proyecto.projectmovilesvfinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.proyecto.projectmovilesvfinal.data.model.Saving

@Dao
interface SavingDao {

    @Insert
    suspend fun insertSaving(saving: Saving)

    @Query("SELECT * FROM saving_table WHERE client=:id")
    fun getSavingsById(id:Int):List<Saving>
}