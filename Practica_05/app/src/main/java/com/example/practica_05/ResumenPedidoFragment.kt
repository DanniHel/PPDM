package com.example.practica_05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class ResumenPedidoFragment : Fragment(R.layout.fragment_resumen_pedido) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comida = arguments?.getString("comida") ?: ""
        val extra = arguments?.getStringArrayList("extras")

        val mensaje = "Seleccionaste: ${extra?.joinToString(", ")}"

        Toast.makeText(context,"$comida", Toast.LENGTH_LONG).show()
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }
}