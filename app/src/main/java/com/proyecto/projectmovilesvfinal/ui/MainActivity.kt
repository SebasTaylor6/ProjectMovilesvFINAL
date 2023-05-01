package com.proyecto.projectmovilesvfinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.proyecto.proyectomovilesv2.data.model.User
import com.proyecto.projectmovilesvfinal.data.viewModel.LoginViewModel
import com.proyecto.proyectofinalmoviles.databinding.ActivityMainBinding


import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var loginViewModel: LoginViewModel
    private var logged : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]


        binding.Exit.setOnClickListener {
            finish()
            exitProcess(0)
        }

        binding.logInBtn.setOnClickListener {
            loginValidation(binding.editTextUserName.text.toString(),binding.editTextTextPassword.text.toString())
        }
    }

    override fun onBackPressed() {
        if (!logged) {
            Toast.makeText(applicationContext,"Inicie sesionjh para continuar",Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginValidation(username:String,password:String){
        if(username.isEmpty()||password.isEmpty()){
            Toast.makeText(applicationContext,"No dejes campos vacios",Toast.LENGTH_SHORT).show()
        } else{

            val user: User = loginViewModel.validate(username,password)

            if (user==null){
                Toast.makeText(applicationContext,"Credenciales Invalidas",Toast.LENGTH_SHORT).show()
            }else{
                roleValidation(user)
            }


        }

    }

    private fun roleValidation(user: User){
        when(user.roleId){
            1->{
                adminView(user)
            }
            2->{
                clientView(user)

            }
            else->{
                Toast.makeText(applicationContext,"No Role Set",Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun adminView(user: User){
        logged = true
        val intent = Intent(this,AdminActivity::class.java)
        intent.putExtra("logged",logged)
        startActivity(intent)
    }

    private fun clientView(user: User){
        logged = true
        val intent = Intent(this,ClientActivity::class.java)
        intent.putExtra("logged",logged)
        intent.putExtra("id",user.id)
    }
}