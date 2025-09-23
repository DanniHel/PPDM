/**
 * Descripción: Actividad para capturar una nota del usuario y enviarla a otra actividad para confirmar o editar.
 * Autor: Danny Quispe Cjuiro
 * Fecha creación: 22/09/2025
 * Fecha última modificación: 22/09/2025
 */

package com.example.p4_ejercicio02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OpcionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        // referenciar a los elementos de la interfaz
        val txtMensage = findViewById<TextView>(R.id.txtMensage)
        val btnComparirCorreo = findViewById<Button>(R.id.btnCompartirCorreo)
        val btnEditar = findViewById<Button>(R.id.btnEditar)

        // recuperar los datos enviardos desde la otra actividad
        val nota = intent.getStringExtra("NOTA")

        // Se mutra los resultados
        txtMensage.text = nota

        // accion al presionar el boton editar
        btnEditar.setOnClickListener {
            // finaliza la actividad actual y regrea a la anterior
            finish()
        }

        // accion al presionar el boton compartir por correo

        btnComparirCorreo.setOnClickListener {
            // crear un inter vacio

            val mensage = Intent()

            // se añade el mensage de tipo string al intent
            mensage.putExtra("RESULT", "Compartido por correo")

            // establecer el resultado como exitoso
            setResult(RESULT_OK,mensage)
            finish()
        }

    }
}