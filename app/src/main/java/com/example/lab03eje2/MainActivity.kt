package com.example.lab03eje2

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var TextName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TextName = findViewById(R.id.text1)
        TextName.text = "Reproduciendo musica"
        Log.e("Mensaje", "Reproduciendo");

        mediaPlayer = MediaPlayer.create(this, R.raw.song)
        mediaPlayer.start()
    }

    override fun onStop() {
        super.onStop()
        pausarAudio()
    }

    override fun onRestart() {
        super.onRestart()
        reiniciarAudio()
    }

    fun pausarAudio(){
        mediaPlayer.pause()
        Log.e("Mensaje", "Se llamo a pausarAudio()")
    }

    fun reiniciarAudio(){
        mediaPlayer.start();
        Log.e("Mensaje", "Se llamo a reiniciarAudio()")
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        finish()
    }
}