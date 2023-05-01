package com.proyecto.projectmovilesvfinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.proyecto.projectmovilesvfinal.data.viewModel.AdminViewModel
import com.proyecto.proyectofinalmoviles.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding
    private lateinit var adminViewModel: AdminViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adminViewModel = ViewModelProvider(this)[AdminViewModel::class.java]

        binding.btnLogout.setOnClickListener {
            logout()
        }

        binding.btnAddClient.setOnClickListener {
            addClient()
        }

        binding.btnAssignLoan.setOnClickListener {
            addLoan()
        }
    }

    fun logout(){
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("logged",false)
        startActivity(intent)
    }

    fun addClient(){
        val intent = Intent(this,CreateClientActivity::class.java)
        startActivity(intent)
    }

    fun addLoan(){

    }
}