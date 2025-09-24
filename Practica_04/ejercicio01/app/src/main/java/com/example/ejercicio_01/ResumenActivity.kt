/**
 * EDICIÓN DE PERFIL CON CONFIRMACIÓN
 *
 * Descripción: Actividad para mostrar los datos del usuario y confirmar o editar.
 * Autor: Danny Quispe Cjuiro
 * Fecha creación: 22/09/2025
 * Fecha última modificación: 23/09/2025
 */


package com.example.ejercicio_01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResumenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        // Referencias a los TextView y botones definidos en el layout
        val txtNombre = findViewById<TextView>(R.id.txtNombre0)
        val txtEdad = findViewById<TextView>(R.id.txtEdad0)
        val txtCiudad = findViewById<TextView>(R.id.txtCiudad0)
        val txtCorreo = findViewById<TextView>(R.id.txtCorreo0)
        val btnEditar = findViewById<Button>(R.id.btnEditar)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)

        // Recuperación de los datos enviados desde FormularioActivity mediante el Intent

        val usuario = intent.getSerializableExtra("USUARIO") as? Usuario

        usuario?.let {
            // Muestra los datos en los TextView, formateando el texto con etiquetas
            txtNombre.text = "Nombre: ${it.nombre}"
            txtEdad.text = "Edad: ${it.edad}"
            txtCiudad.text = "Ciudad: ${it.ciudad}"
            txtCorreo.text = "Correo: ${it.correo}"

        }

        // Acción al pulsar el botón "Editar"
        btnEditar.setOnClickListener {
            // Finaliza la actividad actual y vuelve a FormularioActivity
            finish()
        }

        btnConfirmar.setOnClickListener {
            // Crea un Intent vacío para enviar el resultado de vuelta
            val mensage = Intent()
            // Añade un mensaje indicando que el perfil fue guardado correctamente
            mensage.putExtra("RESULT","Perfil guardado correctamente")
            // Establece el resultado como exitoso (RESULT_OK) y adjunta el mensaje
            setResult(RESULT_OK,mensage)
            // Finaliza esta actividad y retorna a la anterior
            finish()
        }
    }
}