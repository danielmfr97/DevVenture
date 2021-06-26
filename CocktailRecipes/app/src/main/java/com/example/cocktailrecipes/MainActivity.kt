package com.example.cocktailrecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.ViewModelProvider;
import com.bumptech.glide.Glide
import com.example.cocktailrecipes.data.db.DrinkDao
import com.example.cocktailrecipes.data.model.Drink
import com.example.cocktailrecipes.data.model.DrinkList
import com.example.cocktailrecipes.data.network.CocktailService
import com.example.cocktailrecipes.data.repository.DrinkRepository
import com.example.cocktailrecipes.databinding.ActivityMainBinding
import com.example.cocktailrecipes.presentation.DrinkViewModel
import com.example.cocktailrecipes.presentation.adapters.DrinkAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private val viewModel: DrinkViewModel by viewModel()
    private lateinit var mAdapter: DrinkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeObservers()
        initRecyclerView()
    }

    private fun subscribeObservers() {
        viewModel.getDrinks().observe(this@MainActivity, Observer {
            mAdapter.drinkList = it
        })
    }

    private fun initRecyclerView() {
        mAdapter = DrinkAdapter()
        binding.rvDrinks.apply {
            adapter = mAdapter
        }
    }
}