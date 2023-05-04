package com.proyecto.projectmovilesvfinal.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proyecto.proyectofinalmoviles.databinding.ActivityCalculateInstallmentBinding

class CuotaActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCalculateInstallmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityCalculateInstallmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            when(binding.spnTipoCredito.selectedItem.toString().first()){
                'H'->{
                    val monto: Double = (binding.etMonto.text.toString().toDouble()/(binding.spnPlazo.selectedItem.toString().toInt()*12))+ (binding.etMonto.text.toString().toDouble()*0.075)
                    binding.textView2.text = "Total a pagar por mes: "+monto
                }
                'E'->{
                    val monto: Double = (binding.etMonto.text.toString().toDouble()/(binding.spnPlazo.selectedItem.toString().toInt()*12))+ (binding.etMonto.text.toString().toDouble()*0.08)
                    binding.textView2.text = "Total a pagar por mes: "+monto
                }
                'P'->{
                    val monto: Double = (binding.etMonto.text.toString().toDouble()/(binding.spnPlazo.selectedItem.toString().toInt()*12))+ (binding.etMonto.text.toString().toDouble()*0.1)
                    binding.textView2.text = "Total a pagar por mes: "+monto
                }
                'V'->{
                    val monto: Double = (binding.etMonto.text.toString().toDouble()/(binding.spnPlazo.selectedItem.toString().toInt()*12))+ (binding.etMonto.text.toString().toDouble()*0.12)
                    binding.textView2.text = "Total a pagar por mes: "+monto
                }
            }
        }

        binding.btnVolver.setOnClickListener {
            val intent = Intent(this,ClientActivity::class.java)
            startActivity(intent)
        }
    }
}