package com.proyecto.projectmovilesvfinal.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.proyecto.projectmovilesvfinal.data.model.Loan
import com.proyecto.projectmovilesvfinal.data.viewModel.ClientViewModel
import com.proyecto.proyectofinalmoviles.databinding.ActivityCheckLoansBinding

class GetLoanActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCheckLoansBinding
    private lateinit var clientViewModel: ClientViewModel
    private lateinit var loan: List<Loan>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckLoansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras:Bundle? = intent.extras

        clientViewModel = ViewModelProvider(this)[ClientViewModel::class.java]
        if (extras != null) {
            loan = clientViewModel.getLoan(extras.getInt("id"))
        }
        binding.button.setOnClickListener {
            val intent = Intent(this,ClientActivity::class.java)
            startActivity(intent)
        }
        initRecView()
    }

    fun initRecView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adt:LoanAdapter = LoanAdapter(loan)
        adt.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Pagando ve", Toast.LENGTH_SHORT).show()
        })
        binding.recyclerView.adapter = LoanAdapter(loan)

    }
}