package com.proyecto.projectmovilesvfinal.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.proyecto.projectmovilesvfinal.data.model.Client
import com.proyecto.projectmovilesvfinal.data.viewModel.ClientViewModel
import com.proyecto.projectmovilesvfinal.data.viewModel.LoginViewModel
import com.proyecto.proyectofinalmoviles.databinding.ActivityClientBinding
import com.proyecto.proyectofinalmoviles.databinding.ActivityMainBinding

class ClientActivity: AppCompatActivity() {
    private lateinit var binding:ActivityClientBinding
    private lateinit var clientViewModel: ClientViewModel
private lateinit var user:Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras:Bundle? = intent.extras

        clientViewModel = ViewModelProvider(this)[ClientViewModel::class.java]
        if (extras != null) {
            user = clientViewModel.getUser(extras.getInt("id"))
        }


        binding.btnLogout.setOnClickListener {
            logout()
        }

        binding.btnAddClient.setOnClickListener {
            loan()
        }

        binding.btnAssignLoan.setOnClickListener {
            saving()
        }
    }

    fun logout(){
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("logged",false)
        startActivity(intent)
    }

    fun loan(){
        val intent = Intent(this,GetLoanActivity::class.java)
        intent.putExtra("id",user.id)
        startActivity(intent)
    }

    fun saving(){
        val intent = Intent(this,SavingsActivity::class.java)
        intent.putExtra("id",user.id)
        startActivity(intent)
    }


}