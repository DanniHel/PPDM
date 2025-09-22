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

        val txtNombre = findViewById<EditText>(R.id.txtNombre1)
        val txtEdad = findViewById<EditText>(R.id.txtEdad1)
        val txtCiudad = findViewById<EditText>(R.id.txtCiudad1)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo1)
        val btnContinuar = findViewById<Button>(R.id.btnContinuar)

        val launcher =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == RESULT_OK){
                val data = result.data
                val mensage = data?.getStringExtra("RESULT")
                Toast.makeText(this, mensage, Toast.LENGTH_LONG).show()
            }
        }


        btnContinuar.setOnClickListener {
            val nombre = txtNombre.text.toString()
            val edad = txtEdad.text.toString().toInt()
            val ciudad = txtCiudad.text.toString()
            val correo = txtCorreo.text.toString()

            val enviar = Intent(this, ResumenActivity::class.java)

            enviar.putExtra("NOMBRE",nombre)
            enviar.putExtra("EDAD",edad)
            enviar.putExtra("CIUDAD",ciudad)
            enviar.putExtra("CORREO",correo)

            launcher.launch(enviar)
        }
    }
}