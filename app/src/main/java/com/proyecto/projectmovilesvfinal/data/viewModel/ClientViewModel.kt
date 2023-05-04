package com.proyecto.projectmovilesvfinal.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.projectmovilesvfinal.data.database.MainDatabase
import com.proyecto.projectmovilesvfinal.data.model.Client
import com.proyecto.projectmovilesvfinal.data.model.Loan
import com.proyecto.projectmovilesvfinal.data.model.Saving
import com.proyecto.projectmovilesvfinal.data.model.User
import com.proyecto.projectmovilesvfinal.data.repository.ClientRepository
import com.proyecto.projectmovilesvfinal.data.repository.LoanRepository
import com.proyecto.projectmovilesvfinal.data.repository.SavingRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientViewModel(application: Application): AndroidViewModel(application) {
    private val clientRepository: ClientRepository
    private val savingRepository:SavingRepository
    private val loanRepository:LoanRepository
private  val c:List<Client>

    init {
        clientRepository = ClientRepository(MainDatabase.getDatabase(application).clientDao())
        savingRepository = SavingRepository(MainDatabase.getDatabase(application).savingDao())
        loanRepository = LoanRepository(MainDatabase.getDatabase(application).loanDao())
         c= clientRepository.getClients()
    }

    fun getLoan(id:Int):List<Loan>{
        return loanRepository.listOfLoan(id)
    }

    fun insertSaving(saving:Saving){
        viewModelScope.launch(Dispatchers.IO) {
            savingRepository.insertSaving(saving)
        }
    }

    fun getClient(id:Int):Client{
        return clientRepository.getClient(id)
    }

    fun getUser(id:Int):Client{
        return clientRepository.getClientByUser(id)
    }


    fun getSavings(id:Int):List<Saving>{
        return savingRepository.getSavings(id)
    }

    fun modifyUser(client: Client){
        viewModelScope.launch(Dispatchers.IO){
            clientRepository.updateClient(client)
        }
    }
}