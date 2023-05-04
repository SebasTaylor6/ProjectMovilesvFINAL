package com.proyecto.projectmovilesvfinal.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.proyecto.projectmovilesvfinal.data.model.Loan
import com.proyecto.projectmovilesvfinal.data.viewModel.AdminViewModel
import com.proyecto.proyectofinalmoviles.databinding.ActiviyCreateLoanBinding

class AddLoanActivity: AppCompatActivity() {
    private lateinit var binding:ActiviyCreateLoanBinding
    private lateinit var adminViewModel: AdminViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActiviyCreateLoanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adminViewModel = ViewModelProvider(this)[AdminViewModel::class.java]

        binding.btnCalcular.setOnClickListener {
            addLoan()
        }
    }

    fun addLoan(){
        val loan:Loan = Loan(
            binding.editTextMonto2.text.toString().toDouble(),
            binding.spinnerDuracion.selectedItem.toString().toInt(),
            binding.spinnerTipo.selectedItem.toString().first(),
            binding.editTextMonto.text.toString().toInt()
        )
        adminViewModel.addLoan(loan)
        Toast.makeText(this, "Prestamo creado!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,AdminActivity::class.java)
        startActivity(intent)
    }
}