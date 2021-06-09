package com.devventure.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dado01 = findViewById<TextView>(R.id.dado01)
        val dado02 = findViewById<TextView>(R.id.dado02)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            dado01.text = gerarNumeroAleatorio().toString()
            dado02.text = gerarNumeroAleatorio().toString()
        }
    }

    private fun gerarNumeroAleatorio() = (1..6).random()
}