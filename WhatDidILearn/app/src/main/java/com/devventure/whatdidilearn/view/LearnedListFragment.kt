package com.devventure.whatdidilearn.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.devventure.whatdidilearn.R
import com.devventure.whatdidilearn.databinding.FragmentHomeBinding
import com.devventure.whatdidilearn.view.adapters.LearnedItemAdapter
import com.devventure.whatdidilearn.viewmodel.LearnedItemViewModel

class LearnedListFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LearnedItemViewModel by sharedViewModel()
    lateinit var mAdapter: LearnedItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAddItem.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newItemFragment)
        }
        initRecyclerView()
        subscriberObservers()
    }

    private fun initRecyclerView() {
        mAdapter = LearnedItemAdapter()
        binding.learnedItensRecyclerView.adapter = mAdapter
    }

    private fun subscriberObservers() {
        val learnedItens = viewModel.learnedItems
        learnedItens.observe(viewLifecycleOwner, Observer {
            mAdapter.learnedItens = it
        })
    }
}