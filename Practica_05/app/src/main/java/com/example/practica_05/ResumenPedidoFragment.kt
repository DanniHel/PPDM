package com.example.practica_05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ResumenPedidoFragment : Fragment(R.layout.fragment_resumen_pedido) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comida = arguments?.getString("comida") ?: ""
        val extra = arguments?.getStringArrayList("extras")

        val mensaje = "Seleccionaste: ${extra?.joinToString(", ")}"

        // referencias a las vistas
        val lblComida = view.findViewById<TextView>(R.id.lblComidas)
        val lblExtra = view.findViewById<TextView>(R.id.lblExtras)
        val btnEditar = view.findViewById<Button>(R.id.btnEditarPedido)
        val btnConfirmar = view.findViewById<Button>(R.id.btnConfirmarPedido)

        lblComida.text = comida
        lblExtra.text = extra?.joinToString("\n")
    }
}