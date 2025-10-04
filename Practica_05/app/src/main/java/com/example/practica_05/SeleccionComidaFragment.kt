package com.example.practica_05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class SeleccionComidaFragment : Fragment(R.layout.fragment_seleccion_comida) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //instacias de la interfaz
        val btnSiguiente = view.findViewById<Button>(R.id.btnSiguienteComida)
        val opcionRadioGroup = view.findViewById<RadioGroup>(R.id.radioGroupComida)

        btnSiguiente.setOnClickListener {
            // Obtener el ID del RadioButton seleccionado
            val selectId = opcionRadioGroup.checkedRadioButtonId

            if(selectId != -1){
                // Obtener el RadioButton a partir del ID
                val radioBoton = view.findViewById<RadioButton>(selectId)

                // Obtener el texto del RadioButton seleccionado
                val seleccionText = radioBoton.text.toString()

            }
        }
    }
}