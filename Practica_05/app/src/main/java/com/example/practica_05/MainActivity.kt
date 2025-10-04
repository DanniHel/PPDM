package com.example.practica_05

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //iniciar fragmento dentro de una actividad
        supportFragmentManager.beginTransaction().apply {
            add(R.id.iniFragmento, InicioFragment())
            commit()
        }
    }
}