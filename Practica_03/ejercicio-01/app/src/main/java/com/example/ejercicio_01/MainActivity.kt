package com.example.ejercicio_01

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //hacemos una referencia de la imagen
        val imagen = findViewById<ImageView>(R.id.imagen01)

        // escuchar los eventos de la imagen
        imagen.setOnClickListener{
            Toast.makeText(this, "!! karen !!", Toast.LENGTH_LONG).show()
        }

    }
}