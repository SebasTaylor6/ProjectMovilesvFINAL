package com.proyecto.projectmovilesvfinal.data.repository

import com.proyecto.projectmovilesvfinal.data.dao.ClientDao
import com.proyecto.projectmovilesvfinal.data.model.Client


class ClientRepository(private val clientDAO: ClientDao) {
    val readAllData:List<Client> = clientDAO.getAll()

    suspend fun addClient(client: Client){
        return clientDAO.insert(client)
    }

    suspend fun deleteClient(client: Client){
        return clientDAO.delete(client)
    }

    fun getClients():List<Client>{
        return clientDAO.getAll()
    }


    fun getClient(id:Int):Client{
        return clientDAO.getClient(id)
    }

    fun getClientById(id:String):Client{
        return clientDAO.getClientById(id)
    }

    fun getClientByUser(id:Int):Client{
        return clientDAO.getClientByUser(id)
    }

    suspend fun updateClient(client:Client){
       return clientDAO.updateClient(client)
    }



}