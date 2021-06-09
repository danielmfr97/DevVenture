package com.devventure.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listDices = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
            R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

        val diceOne = findViewById<ImageView>(R.id.ivDiceOne)
        val diceTwo = findViewById<ImageView>(R.id.ivDiceTwo)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            diceOne.setImageResource(listDices.random())
            diceTwo.setImageResource(listDices.random())
        }
    }

    private fun getRandomNumber() = (1..6).random()
}