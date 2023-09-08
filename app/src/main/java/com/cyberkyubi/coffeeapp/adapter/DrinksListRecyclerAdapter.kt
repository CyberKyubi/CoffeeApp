package com.cyberkyubi.coffeeapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.cyberkyubi.coffeeapp.R
import com.cyberkyubi.domain.model.DrinkModel

class DrinksListRecyclerAdapter (
    private var drinksList: List<DrinkModel>
) : RecyclerView.Adapter<DrinksListRecyclerAdapter.DrinksListViewHolder>() {

    class DrinksListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val drinkCard: ConstraintLayout = itemView.findViewById(R.id.drink_card_constraint)
        val drawableResource: ImageView = itemView.findViewById(R.id.drink_image)
        val drinkName: TextView = itemView.findViewById(R.id.drink_name_text)
        val drinkPrice: TextView = itemView.findViewById(R.id.drink_price_text)
        val iconsListLinear: LinearLayout = itemView.findViewById(R.id.icons_list_linear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_drinks_list, parent, false)
        return DrinksListViewHolder(itemView)
    }

    override fun getItemCount() = drinksList.size

    override fun onBindViewHolder(holder: DrinksListViewHolder, position: Int) {
        val item: DrinkModel = drinksList[position]

        holder.drinkName.text = item.name
        holder.drinkPrice.text = String.format(holder.itemView.context.getString(R.string.drink_price), item.price)

        holder.iconsListLinear.removeAllViews()
        for (ingredientIcon in item.ingredients) {
            val imageView = ImageView(holder.itemView.context)
            imageView.setImageResource(ingredientIcon)

            val layoutParams = LinearLayout.LayoutParams(64, 64)
            layoutParams.setMargins(4, 8, 4, 8)
            imageView.layoutParams = layoutParams

            holder.iconsListLinear.addView(imageView)
        }
    }

    fun updateDrinks(drinks: List<DrinkModel>) {
        drinksList = drinks
        this.notifyDataSetChanged()
    }
}