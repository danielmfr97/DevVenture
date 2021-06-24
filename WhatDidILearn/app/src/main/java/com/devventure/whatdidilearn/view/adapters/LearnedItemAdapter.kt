package com.devventure.whatdidilearn.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devventure.whatdidilearn.R
import com.devventure.whatdidilearn.entities.LearnedItem

class LearnedItemAdapter: RecyclerView.Adapter<LearnedItemAdapter.LearnedItemViewHolder>() {
    var learnedItens = listOf<LearnedItem>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    inner class LearnedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val titleContainer : TextView = itemView.findViewById(R.id.itemTitle)
        private val descriptionContainer : TextView = itemView.findViewById(R.id.itemDescription)
        private val colorContainer : View = itemView.findViewById(R.id.itemColor)

        fun bind(learnedItem: LearnedItem) {
            titleContainer.text = learnedItem.name
            descriptionContainer.text = learnedItem.description

            when(learnedItem.understandingLevel) {
                UnderstandingLevel.LOW  -> colorContainer.setBackgroundResource(R.color.red)
                UnderstandingLevel.MEDIUM  -> colorContainer.setBackgroundResource(R.color.yellow)
                UnderstandingLevel.HIGH  -> colorContainer.setBackgroundResource(R.color.green)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.learned_item, parent, false)

        return LearnedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        val learnedItem = learnedItens[position]
        holder.bind(learnedItem)
    }

    override fun getItemCount(): Int {
        return learnedItens.size
    }
}