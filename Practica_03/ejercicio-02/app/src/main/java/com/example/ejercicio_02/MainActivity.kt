package com.example.ejercicio_02

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // declaramos mediaPlayer y lo iniciamos como nulo
    var mediaPlayer: MediaPlayer? = null

    //funcion para detener la reproduccion
    fun stopPlayer(){
        mediaPlayer?.release()
        mediaPlayer = null
        Toast.makeText(this,"Se ha detenido", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // instanciamos los botones
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnPause = findViewById<Button>(R.id.btnPausa)
        val btnStop = findViewById< ImageButton>(R.id.btnStop)

        //Reproducir la musica
        btnPlay.setOnClickListener {

            if(mediaPlayer==null){
                //sobrescribimos la variable y lo iniciamos
                mediaPlayer = MediaPlayer.create(this, R.raw.music01)
                mediaPlayer?.setOnCompletionListener {
                    stopPlayer()
                }

            }
            // se inicia con la reproduccion
            mediaPlayer?.start()

            Toast.makeText(this, "Reproduciendo...", Toast.LENGTH_LONG).show()
        }

        //Pausar la musica
        btnPause.setOnClickListener {
            if (mediaPlayer?.isPlaying == true){
                mediaPlayer?.pause()
                Toast.makeText(this,"Se ha pausado la musica", Toast.LENGTH_LONG).show()
            }
        }

        // detener
        btnStop.setOnClickListener {
            stopPlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        stopPlayer()
    }
}