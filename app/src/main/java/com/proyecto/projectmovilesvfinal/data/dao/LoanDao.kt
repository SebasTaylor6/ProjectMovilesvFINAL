package com.proyecto.projectmovilesvfinal.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.proyecto.projectmovilesvfinal.data.model.Loan

@Dao
interface LoanDao {
    @Query("SELECT * FROM loan_table")
    fun getAll(): List<Loan>

    @Query("SELECT * FROM loan_table WHERE client=:id")
    fun getAllByID(id:Int): List<Loan>

    @Insert
    suspend fun insertLoan(loan: Loan)


}