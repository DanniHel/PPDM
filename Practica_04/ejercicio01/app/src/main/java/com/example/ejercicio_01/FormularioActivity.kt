/**
 *EDICIÓN DE PERFIL CON CONFIRMACIÓN
 *
 * Descripción: Actividad para capturar datos de un usuario (Nombre, Edad, Ciudad, Correo)
 * Autor: Danny Quispe Cjuiro
 * Fecha creación: 22/09/2025
 * Fecha última modificación: 23/09/2025
 */
package com.example.ejercicio_01

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

class FormularioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        // Referencias de los elementos de la interfaz
        val txtNombre = findViewById<EditText>(R.id.txtNombre1)
        val txtEdad = findViewById<EditText>(R.id.txtEdad1)
        val txtCiudad = findViewById<EditText>(R.id.txtCiudad1)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo1)
        val btnContinuar = findViewById<Button>(R.id.btnContinuar)

        // registro de un lanzador para iniciar otra actividad y esperar un resultado
        val launcher =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            //verificar si la segunda actividad devolvio un resultado satisfactorio
            if(result.resultCode == RESULT_OK){
                val data = result.data
                // recuperar el mensage devuelto desde la otra actividad
                val mensage = data?.getStringExtra("RESULT")
                // se muestra el resultado en un toast
                Toast.makeText(this, mensage, Toast.LENGTH_LONG).show()

                // Limpiar los campos después de confirmar
                txtNombre.setText("")
                txtEdad.setText("")
                txtCiudad.setText("")
                txtCorreo.setText("")
            }
        }

        // Definir la accion al presionar el boton
        btnContinuar.setOnClickListener {
            // convertimos los valores ingresados por el usuario
            val nombre = txtNombre.text.toString()
            val edad = txtEdad.text.toString().toInt()
            val ciudad = txtCiudad.text.toString()
            val correo = txtCorreo.text.toString()

            // instancia del dataclass
            val usuario = Usuario(nombre,edad,ciudad,correo)

            // crea un Intent para iniciar la actividad ResumenActivity
            val enviar = Intent(this, ResumenActivity::class.java)

            // agregamos los datos al intent para pasarlo a la siguiente actividad
            enviar.putExtra("USUARIO",usuario)


            // Lanza la nueva actividad usando el launcher registrado anteriormente
            launcher.launch(enviar)
        }
    }
}