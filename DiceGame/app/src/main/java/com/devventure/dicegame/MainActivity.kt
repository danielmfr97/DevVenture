package com.devventure.dicegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils.getString

private const val TAG = "MeuCicloVida"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "OnCreate")
        Log.i(TAG, "${intent.getStringExtra("playerName")}")

        val playerName = intent.getStringExtra("playerName")

        val listDices = listOf(R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
            R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6)

        val diceOne = findViewById<ImageView>(R.id.ivDiceOne)
        val diceTwo = findViewById<ImageView>(R.id.ivDiceTwo)
        val button = findViewById<Button>(R.id.button)
        val tvHelloPlayer = findViewById<TextView>(R.id.textView)

        tvHelloPlayer.text = getString(R.string.playerName, playerName)

        button.setOnClickListener {
            diceOne.setImageResource(listDices.random())
            diceTwo.setImageResource(listDices.random())
        }
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "OnDestroy")
    }

    private fun getRandomNumber() = (1..6).random()
}