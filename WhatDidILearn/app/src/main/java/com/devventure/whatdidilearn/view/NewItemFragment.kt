package com.devventure.whatdidilearn.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devventure.whatdidilearn.databinding.FragmentNewItemBinding

class NewItemFragment : Fragment() {
    private var _binding: FragmentNewItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewItemBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

}