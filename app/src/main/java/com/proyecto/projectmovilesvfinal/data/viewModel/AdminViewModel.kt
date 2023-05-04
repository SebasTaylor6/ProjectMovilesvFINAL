package com.proyecto.projectmovilesvfinal.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.projectmovilesvfinal.data.repository.UserRepository
import com.proyecto.projectmovilesvfinal.data.database.MainDatabase
import com.proyecto.projectmovilesvfinal.data.model.Client
import com.proyecto.projectmovilesvfinal.data.model.Loan
import com.proyecto.projectmovilesvfinal.data.model.User
import com.proyecto.projectmovilesvfinal.data.repository.ClientRepository
import com.proyecto.projectmovilesvfinal.data.repository.LoanRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AdminViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository: UserRepository
    private val clientRepository: ClientRepository
    private val loanRepository:LoanRepository
    private lateinit var userList:List<User>

    init {
        userRepository = UserRepository(MainDatabase.getDatabase(application).userDao())
        clientRepository = ClientRepository(MainDatabase.getDatabase(application).clientDao())
        loanRepository = LoanRepository(MainDatabase.getDatabase(application).loanDao())


    }
    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            userRepository.addUser(user)
        }
    }

    fun addClient( client: Client){
        userList=userRepository.readAllData()
        client.username = userList.size

        viewModelScope.launch(Dispatchers.IO){
            clientRepository.addClient(client)
        }
    }


    fun addLoan(loan: Loan) {
        val client:Client = clientRepository.getClientById(loan.client.toString())
        loan.client = client.id!!
        viewModelScope.launch(Dispatchers.IO) {
            loanRepository.insertLoan(loan)
        }

    }
}