package com.proyecto.projectmovilesvfinal.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @ColumnInfo(name = "username") val username:String,
    @ColumnInfo(name = "password") val password:String,
    @ColumnInfo(name = "role_id") val roleId:Int,

    ){
    @PrimaryKey(autoGenerate = true) var id:Int? = null
}
