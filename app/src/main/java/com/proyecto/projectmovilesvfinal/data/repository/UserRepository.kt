package com.proyecto.projectmovilesvfinal.data.repository

import com.proyecto.projectmovilesvfinal.data.dao.UserDao
import com.proyecto.projectmovilesvfinal.data.model.User


class UserRepository(private val userDAO: UserDao) {

    suspend fun addUser(user: User){
        return userDAO.insert(user)
    }

    fun validate(username:String,password:String): User {
        return userDAO.validateLogin(username,password)
    }

    fun readAllData():List<User>{
        return userDAO.getAll()
    }

}