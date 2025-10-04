package com.example.practica_05

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class SeleccionExtrasFragment : Fragment(R.layout.fragment_seleccion_extras) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comida = arguments?.getString("comida") ?: ""

        // referencias de las vistas
        val CheckBoxBebidas = view.findViewById<CheckBox>(R.id.checkBebida)
        val CheckBoxPapas = view.findViewById<CheckBox>(R.id.checkPapas)
        val CheckBoxPostre = view.findViewById<CheckBox>(R.id.checkPostre)
        val btnSiguiente = view.findViewById<Button>(R.id.btnSiguienteExtras)

        btnSiguiente.setOnClickListener {
            val seleccionados = mutableListOf<String>()

            if(CheckBoxBebidas.isChecked){
                seleccionados.add(CheckBoxBebidas.text.toString())
            }
            if(CheckBoxPapas.isChecked){
                seleccionados.add(CheckBoxPapas.text.toString())
            }
            if(CheckBoxPostre.isChecked){
                seleccionados.add(CheckBoxPostre.text.toString())
            }

            // ir a otro fragmento
            requireActivity().supportFragmentManager.beginTransaction().apply {
                // enviar datos

                val datos = bundleOf("comida" to comida, "extras" to seleccionados)

                // instancia del fragmento resumen
                val resumenFragmento = ResumenPedidoFragment()
                resumenFragmento.arguments = datos

                replace(R.id.iniFragmento,resumenFragmento)
                addToBackStack("EXTRA")
                commit()
            }

        }
    }
}