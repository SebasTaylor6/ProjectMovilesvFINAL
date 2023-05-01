package com.proyecto.projectmovilesvfinal.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.proyecto.projectmovilesvfinal.data.database.MainDatabase
import com.proyecto.proyectomovilesv2.data.model.User
import com.proyecto.projectmovilesvfinal.data.repository.ClientRepository
import com.proyecto.projectmovilesvfinal.data.repository.UserRepository

class LoginViewModel(application: Application):AndroidViewModel(application) {
    private val userRepository: UserRepository
    private val clientRepository: ClientRepository

    init {
        userRepository = UserRepository(MainDatabase.getDatabase(application).userDao())
        clientRepository = ClientRepository(MainDatabase.getDatabase(application).clientDao())


    }


    fun validate(username: String, password: String): User {

        return userRepository.validate(username, password)
    }
}