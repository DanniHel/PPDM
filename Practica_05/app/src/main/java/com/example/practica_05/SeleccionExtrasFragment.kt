package com.example.practica_05

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

class SeleccionExtrasFragment : Fragment(R.layout.fragment_seleccion_extras) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comida = arguments?.getString("comida") ?: ""

        
    }
}