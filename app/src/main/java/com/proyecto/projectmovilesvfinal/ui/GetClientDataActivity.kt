package com.proyecto.projectmovilesvfinal.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.proyecto.projectmovilesvfinal.data.model.Client
import com.proyecto.projectmovilesvfinal.data.viewModel.ClientViewModel
import com.proyecto.proyectofinalmoviles.databinding.ActivityPersonalInformationBinding
import java.time.LocalDate

class GetClientDataActivity: AppCompatActivity() {
    private lateinit var binding: ActivityPersonalInformationBinding
    private lateinit var clientViewModel: ClientViewModel
    private lateinit var user: Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityPersonalInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clientViewModel = ViewModelProvider(this)[ClientViewModel::class.java]
        val extras:Bundle? = intent.extras
        if (extras != null) {
            user = clientViewModel.getUser(extras.getInt("id")+1)
        }

        binding.etNombre.setText(user.name)
        binding.etSalario.setText(user.salary.toString())
        binding.etFechaNacimiento.setText(user.birthDate.toString())
        when(user.maritalStatus){
            "Casado"->{
                binding.spinnerEstadoCivil.setSelection(1)
            }
            "Soltero"->{
                binding.spinnerEstadoCivil.setSelection(0)

            }
            "Divorciado"->{
                binding.spinnerEstadoCivil.setSelection(2)

            }
            "Viudo"->{
                binding.spinnerEstadoCivil.setSelection(3)

            }
        }
        binding.etTelefono.setText(user.phoneNumber)

        binding.backBtn.setOnClickListener{
            val intent = Intent(this,ClientActivity::class.java)
            startActivity(intent)
        }

        binding.sendBtn.setOnClickListener {
            save()
        }

    }

    fun save(){
        user.name = binding.etNombre.text.toString()
        user.phoneNumber = binding.etTelefono.text.toString()
        user.salary = binding.etSalario.text.toString().toDouble()
        user.maritalStatus = binding.spinnerEstadoCivil.selectedItem.toString()
        user.birthDate = LocalDate.parse(binding.etFechaNacimiento.text.toString())
        clientViewModel.modifyUser(user);

        Toast.makeText(this, "Usuario Modificado!", Toast.LENGTH_SHORT).show()

        val intent = Intent(this,ClientActivity::class.java)
        intent.putExtra("id",user.id)
        startActivity(intent)
    }
}