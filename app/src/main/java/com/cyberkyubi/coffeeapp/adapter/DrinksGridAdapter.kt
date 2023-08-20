package com.cyberkyubi.coffeeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.cyberkyubi.coffeeapp.R

import androidx.cardview.widget.CardView
import com.cyberkyubi.domain.model.DrinkModel

class DrinksGridAdapter(
    private var context: Context,
    private var listDrinks: List<DrinkModel>
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return listDrinks.size
    }

    override fun getItem(position: Int): DrinkModel {
        return listDrinks[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.gridview_drinks, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val item = getItem(position)

        holder.drawableResource.setImageDrawable(AppCompatResources.getDrawable(context, R.drawable.ic_cappuccino))
        holder.nameDrink.text = item.name
        return view
    }

    private class ViewHolder(itemView: View) {
        val cardDrink: CardView = itemView.findViewById(R.id.cardDrink)
        val drawableResource: ImageView = itemView.findViewById(R.id.iconDrink)
        val nameDrink: TextView = itemView.findViewById(R.id.nameDrink)
    }

    fun updateDrinks(drinks: List<DrinkModel>) {
        listDrinks = drinks
        notifyDataSetChanged()
    }
}