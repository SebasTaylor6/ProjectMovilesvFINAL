package com.proyecto.projectmovilesvfinal.data.repository

import com.proyecto.proyectomovilesv2.data.dao.UserDao
import com.proyecto.proyectomovilesv2.data.model.User


class UserRepository(private val userDAO: UserDao) {
    val readAllData:List<User> = userDAO.getAll()

    suspend fun addUser(user: User){
        return userDAO.insert(user)
    }

    fun validate(username:String,password:String): User {
        return userDAO.validateLogin(username,password)
    }


}