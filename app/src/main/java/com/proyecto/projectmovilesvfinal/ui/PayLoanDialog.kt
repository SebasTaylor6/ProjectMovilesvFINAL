package com.proyecto.projectmovilesvfinal.ui

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.proyecto.proyectofinalmoviles.databinding.PayLoanDialogBinding


class PayLoanDialog(
    private val onSubmitClickListener: ()-> Unit
) :DialogFragment(){
    private lateinit var binding: PayLoanDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = PayLoanDialogBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireActivity())
        builder.setView(binding.root)

        binding.btnPagar.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "aaaaa", Toast.LENGTH_SHORT).show()
        })


        val dialog = builder.create()
        return dialog

    }
}