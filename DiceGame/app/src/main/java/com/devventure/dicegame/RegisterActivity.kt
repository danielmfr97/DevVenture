package com.devventure.dicegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

const val PLAYER_NAME = "playerName"
class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val playerName = findViewById<EditText>(R.id.etPlayerName)
        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra(PLAYER_NAME, playerName.text.toString())
            }
            startActivity(intent)
        }
    }
}