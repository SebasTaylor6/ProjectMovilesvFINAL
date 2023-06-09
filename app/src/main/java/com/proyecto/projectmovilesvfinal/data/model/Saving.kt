package com.proyecto.projectmovilesvfinal.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.proyecto.projectmovilesvfinal.data.model.Client

@Entity(tableName = "saving_table",
    foreignKeys = [ForeignKey(entity = Client::class,
        childColumns = ["client"],
        parentColumns = ["id"])])
data class Saving(

    @ColumnInfo(name = "saving") val saving:Double,
    @ColumnInfo(name = "type") val type:String,
    @ColumnInfo(name = "client") val client:Int,
){
    @PrimaryKey(autoGenerate = true) var id:Int?=null
}
