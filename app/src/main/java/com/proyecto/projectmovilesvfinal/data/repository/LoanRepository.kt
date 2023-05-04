package com.proyecto.projectmovilesvfinal.data.repository

import com.proyecto.projectmovilesvfinal.data.dao.LoanDao
import com.proyecto.projectmovilesvfinal.data.model.Loan

class LoanRepository(private val loanDao: LoanDao) {
    suspend fun insertLoan(loan:Loan){
        loanDao.insertLoan(loan)
    }

    fun listOfLoan(id:Int):List<Loan>{
        return loanDao.getAllByID(id)
    }
}