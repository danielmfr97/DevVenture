package com.devventure.whatdidilearn.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.devventure.whatdidilearn.R
import com.devventure.whatdidilearn.databinding.FragmentHomeBinding
import com.devventure.whatdidilearn.view.adapters.LearnedItemAdapter
import com.devventure.whatdidilearn.viewmodel.HomeViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val recycler = binding.learnedItensRecyclerView
        val adapter = LearnedItemAdapter()
        val learnedItens = viewModel.learnedItems
        learnedItens.observe(viewLifecycleOwner, Observer {
            adapter.learnedItens = it
        })

        recycler.adapter = adapter
        binding.fabAddItem.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newItemFragment)
        }

        return binding.root
    }
}