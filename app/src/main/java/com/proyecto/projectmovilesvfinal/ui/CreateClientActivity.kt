package com.proyecto.projectmovilesvfinal.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.proyecto.projectmovilesvfinal.data.viewModel.AdminViewModel
import com.proyecto.proyectofinalmoviles.databinding.ActivityCreateClientBinding
import com.proyecto.projectmovilesvfinal.data.model.Client
import com.proyecto.projectmovilesvfinal.data.model.User
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CreateClientActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCreateClientBinding
    private lateinit var adminViewModel: AdminViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateClientBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adminViewModel = ViewModelProvider(this)[AdminViewModel::class.java]

        binding.sendBtn.setOnClickListener {
            createClient()
        }
    }

    fun createClient(){
        val formatter:DateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy")
        val user: User = (User(binding.etCedula.text.toString(),binding.password.text.toString(),2))
        adminViewModel.addUser(user)

        adminViewModel = ViewModelProvider(this)[AdminViewModel::class.java]



        val client:Client = Client(binding.etCedula.text.toString(),
            binding.etNombre.text.toString(),
            binding.etSalario.text.toString().toDouble(),
            binding.etTelefono.text.toString(),
            LocalDate.parse(binding.etFechaNacimiento.text.toString(),formatter),
            binding.spinnerEstadoCivil.selectedItem.toString(),user.id)
        adminViewModel.addClient(client)

        Toast.makeText(this, "Cliente creado!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,AdminActivity::class.java)
        startActivity(intent)
    }
}