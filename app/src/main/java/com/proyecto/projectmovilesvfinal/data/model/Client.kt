package com.proyecto.projectmovilesvfinal.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "client_table",
foreignKeys = [ForeignKey(
    entity = User::class,
    childColumns = ["user"],
    parentColumns = ["id"]
)])
data class Client(
    @ColumnInfo(name = "client_id") val clientId:String,
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "salary") var salary:Double,
    @ColumnInfo(name = "phone_number") var phoneNumber:String,
    @ColumnInfo(name = "birth_date") var birthDate: LocalDate?,
    @ColumnInfo(name = "marital_status") var maritalStatus:String,
    @ColumnInfo(name = "user") var username:Int?,

    ){
    @PrimaryKey(autoGenerate = true) var id:Int? = null
}
