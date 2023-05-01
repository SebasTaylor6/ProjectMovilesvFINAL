package com.proyecto.projectmovilesvfinal.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.proyecto.proyectomovilesv2.data.model.User
import java.time.LocalDate

@Entity(tableName = "client_table",
foreignKeys = [ForeignKey(
    entity = User::class,
    childColumns = ["user"],
    parentColumns = ["id"]
)])
data class Client(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name = "client_id") val clientId:String,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "salary") val salary:Double,
    @ColumnInfo(name = "phone_number") val phoneNumber:String,
    @ColumnInfo(name = "birth_date") val birthDate: LocalDate?,
    @ColumnInfo(name = "marital_status") val maritalStatus:String,
    @ColumnInfo(name = "user") val username:Int,
)
