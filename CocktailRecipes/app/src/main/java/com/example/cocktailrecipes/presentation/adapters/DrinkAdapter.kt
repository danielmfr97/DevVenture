package com.example.cocktailrecipes.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailrecipes.R
import com.example.cocktailrecipes.data.model.Drink

class DrinkAdapter : RecyclerView.Adapter<DrinkAdapter.MyViewHolder>() {
    var drinkList = listOf<Drink>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val drinkImage: ImageView = itemView.findViewById(R.id.ivDrink)
        private val drinkTitle: TextView = itemView.findViewById(R.id.tvDrinkTitle)

        fun bind(drink: Drink) {
            drinkTitle.text = drink.strDrink
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_drink, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val drink = drinkList[position]
        holder.bind(drink)
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }
}