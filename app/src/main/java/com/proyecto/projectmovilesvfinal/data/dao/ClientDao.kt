package com.proyecto.projectmovilesvfinal.data.dao

import androidx.room.*
import com.proyecto.projectmovilesvfinal.data.model.Client
import java.time.LocalDate

@Dao
interface ClientDao {

    @Query("SELECT * FROM client_table")
    fun getAll(): List<Client>

    @Query("SELECT * FROM client_table where id=:id")
    fun getClient(id:Int): Client

    @Query("SELECT * FROM client_table where client_id=:id")
    fun getClientById(id:String): Client

    @Query("SELECT * FROM client_table where user=:id")
    fun getClientByUser(id:Int): Client

    @Update
    fun updateClient(client: Client)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(client: Client)

    @Delete
    suspend fun delete(client: Client)

    @Query("DELETE FROM client_table")
    suspend fun deleteAll()
}