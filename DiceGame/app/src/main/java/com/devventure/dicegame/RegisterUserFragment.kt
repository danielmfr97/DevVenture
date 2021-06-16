package com.devventure.dicegame

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.devventure.dicegame.databinding.FragmentRegisterUserBinding

class RegisterUserFragment : Fragment() {

    private var _binding: FragmentRegisterUserBinding? = null
    private val binding get() = _binding!!

    private lateinit var diceAnimation: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterUserBinding.inflate(inflater, container, false)
        val etPlayer = binding.etPlayerName
        val btnStart = binding.btnStart
        val animationView = binding.ivDiceAnim
        animationView.setBackgroundResource(R.drawable.animation)
        diceAnimation = animationView.background as AnimationDrawable

        btnStart.setOnClickListener {
            val playerName = etPlayer.text.toString()
            findNavController().navigate(R.id.action_registerUserFragment_to_throwDiceFragment,
                bundleOf("playerName" to playerName))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        diceAnimation.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}