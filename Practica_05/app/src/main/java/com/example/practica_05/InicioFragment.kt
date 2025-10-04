/**
 * Fragmento inicial que permite comenzar un nuevo pedido
 * Autor: Danny Quispe Cjuiro
 * Fecha creación: 03-10-25
 * Fecha última modificación: 03-10-25
 */

package com.example.practica_05

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment



class InicioFragment : Fragment(R.layout.fragment_inicio) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNuevoPedido = view.findViewById<Button>(R.id.btnNuevoPedido)

        btnNuevoPedido.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.iniFragmento, SeleccionComidaFragment())
                commit()
            }
        }
    }
}