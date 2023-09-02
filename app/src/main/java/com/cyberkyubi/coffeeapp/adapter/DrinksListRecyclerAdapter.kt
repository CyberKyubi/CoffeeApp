package com.cyberkyubi.coffeeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.cyberkyubi.coffeeapp.R
import com.cyberkyubi.domain.model.MenuModel

class DrinksListRecyclerAdapter (
    private var drinksList: List<MenuModel>
) : RecyclerView.Adapter<DrinksListRecyclerAdapter.DrinksListViewHolder>() {

    class DrinksListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val drinkCard: ConstraintLayout = itemView.findViewById(R.id.drink_card_constraint)
        val drawableResource: ImageView = itemView.findViewById(R.id.drink_image)
        val drinkName: TextView = itemView.findViewById(R.id.drink_name_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_drinks_list, parent, false)
        return DrinksListRecyclerAdapter.DrinksListViewHolder(itemView)
    }

    override fun getItemCount() = drinksList.size

    override fun onBindViewHolder(holder: DrinksListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}