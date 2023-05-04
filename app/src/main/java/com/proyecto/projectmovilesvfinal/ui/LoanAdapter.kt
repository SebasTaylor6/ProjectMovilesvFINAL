package com.proyecto.projectmovilesvfinal.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.projectmovilesvfinal.data.model.Loan
import com.proyecto.proyectofinalmoviles.R

class LoanAdapter(val loanList:List<Loan>):RecyclerView.Adapter<LoanViewHolder>(),View.OnClickListener {
    private lateinit var listener:View.OnClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanViewHolder {
        val layoutInflater:View = LayoutInflater.from(parent.context).inflate(R.layout.item_loan,parent,false)
        layoutInflater.setOnClickListener(this)
        return LoanViewHolder(layoutInflater)
    }


    override fun onBindViewHolder(holder: LoanViewHolder, position: Int) {
        val item = loanList[position]
        holder.render(item)
    }

fun setOnClickListener(view:View.OnClickListener){
    this.listener =view
}

    override fun getItemCount(): Int = loanList.size
    override fun onClick(v: View?) {
        if(listener!=null){
            listener.onClick(v)
        }
    }

}