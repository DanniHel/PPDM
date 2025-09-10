package com.example.practica_03

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ejercicio01)

        val imagen = findViewById<ImageView>(R.id.miImagen)

        imagen.setOnClickListener {
            Toast.makeText(this, "¡Has tocado la imagen!", Toast.LENGTH_SHORT).show()
        }

    }
}