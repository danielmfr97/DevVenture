package com.devventure.dicegame

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devventure.dicegame.databinding.FragmentThrowDiceBinding

class ThrowDiceFragment : Fragment() {
    private var _binding: FragmentThrowDiceBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThrowDiceBinding.inflate(inflater, container, false)
        val listDices = listOf(
            R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,
            R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6
        )

        val diceOne = binding.ivDiceOne
        val diceTwo = binding.ivDiceTwo
        val button = binding.button
        val tvHelloPlayer = binding.textView
        val shareButton = binding.floatingActionButton
        //TODO: Recuperar informação da fragment RegisterUserFragment
        val playerName = "teste"
        tvHelloPlayer.text = getString(R.string.playerName, arguments?.getString("playerName").toString())

        button.setOnClickListener {
            diceOne.setImageResource(listDices.random())
            diceTwo.setImageResource(listDices.random())
        }

        shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT, "VOCÊ É SORTUDO!")
                setPackage("com.whatsapp")
                type = "text/plain"
            }
            activity?.packageManager?.run {
                if (intent.resolveActivity(this) != null)
                    startActivity(intent)
                else
                    Toast.makeText(context, "Impossível executar", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }
}