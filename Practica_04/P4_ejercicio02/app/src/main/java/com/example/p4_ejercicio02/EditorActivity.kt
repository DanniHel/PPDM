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
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        // referencia de los elementos de la interfaz
        val txtNota = findViewById<EditText>(R.id.txtNota1)
        val btnCompartir = findViewById<Button>(R.id.btnCompartir)

        // registro de un lanzador para iniciar otra actividady esperar resultado

        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            // verificamos si la actividad siguiente devolvió un resultado
            if (result.resultCode == RESULT_OK){
                val data = result.data
                val mensage = data?.getStringExtra("RESULT")

                Toast.makeText(this,mensage, Toast.LENGTH_LONG).show()

                //limpiar el campo
                txtNota.setText("")
            }
        }

        //accion al presionar el boton compartir
        btnCompartir.setOnClickListener {
            val nota = txtNota.text.toString()

            // crear el intent para iniciar una nueva actividad
            val enviar = Intent(this, OpcionesActivity::class.java)

            // agregamos datos al intent
            enviar.putExtra("NOTA",nota)

            // lanzar la nueva actividad usando el launcher de arriba
            launcher.launch(enviar)
        }

    }
}