package com.proyecto.projectmovilesvfinal.ui

import android.app.AlertDialog
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.projectmovilesvfinal.data.model.Loan
import com.proyecto.proyectofinalmoviles.R

class LoanViewHolder(val view:View): RecyclerView.ViewHolder(view) {

    val type = view.findViewById<TextView>(R.id.tipo)
    val credit = view.findViewById<TextView>(R.id.credito)
    val time = view.findViewById<TextView>(R.id.tiempo)
    val button = view.findViewById<Button>(R.id.btnPagar)


    fun render(loan:Loan){
        type.text = loan.type.toString()
        credit.text = loan.credit.toString()
        time.text = loan.time.toString()

    }


}