package com.proyecto.projectmovilesvfinal.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.proyecto.projectmovilesvfinal.data.model.Client

@Entity(tableName = "loan_table",
foreignKeys = [ForeignKey(entity = Client::class,
    childColumns = ["client"],
    parentColumns = ["id"])])
data class Loan(
    @ColumnInfo(name = "credit") val credit:Double,
    @ColumnInfo(name = "time") val time:Int,
    @ColumnInfo(name = "type") val type:Char,
    @ColumnInfo(name = "client") var client:Int,
    ){
    @PrimaryKey(autoGenerate = true) var id:Int? = null
}
