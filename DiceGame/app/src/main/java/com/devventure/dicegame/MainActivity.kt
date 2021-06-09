package com.devventure.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devventure.dicegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.dado01.text = gerarNumeroAleatorio().toString()
            binding.dado02.text = gerarNumeroAleatorio().toString()
        }
    }

    private fun gerarNumeroAleatorio() = (1..6).random()
}