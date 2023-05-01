package com.proyecto.projectmovilesvfinal.data.dao

import androidx.room.*
import com.proyecto.projectmovilesvfinal.data.model.Client
import com.proyecto.proyectomovilesv2.data.model.User

@Dao
interface ClientDao {

    @Query("SELECT * FROM client_table")
    fun getAll(): List<Client>

    @Query("SELECT * FROM client_table where id=:id")
    fun getClient(id:Int): Client

    @Query("SELECT * FROM client_table where user=:id")
    fun getClientByUser(id:Int): Client

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(client: Client)

    @Delete
    suspend fun delete(client: Client)

    @Query("DELETE FROM client_table")
    suspend fun deleteAll()
}