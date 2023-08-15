package com.cyberkyubi.coffeeapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import com.cyberkyubi.coffeeapp.R

import com.cyberkyubi.coffeeapp.presentation.ProductListingActivity
import com.cyberkyubi.domain.model.MenuModel

class MenuGridViewAdapter(
    private var context: Context,
    private var listMenu: List<MenuModel>
): BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getCount(): Int {
        return listMenu.size
    }

    override fun getItem(position: Int): MenuModel {
        return listMenu[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.gridview_item, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        holder.cardOfProduct.setOnClickListener {
            val intent = Intent(context, ProductListingActivity::class.java)
            context.startActivity(intent)
        }

        val item = getItem(position)

        val drawable = when (item.categoryId) {
            1 -> AppCompatResources.getDrawable(context, R.drawable.ic_coffee_cup)
            2 -> AppCompatResources.getDrawable(context, R.drawable.ic_sweets)
            else -> {
                AppCompatResources.getDrawable(context, R.drawable.ic_warning)
            }
        }
        holder.drawableResource.setImageDrawable(drawable)
        holder.textView.text = item.title
        return view
    }

    private class ViewHolder(itemView: View) {
        val cardOfProduct: CardView = itemView.findViewById(R.id.cardOfProduct)
        val drawableResource: ImageView = itemView.findViewById(R.id.iconProduct)
        val textView: TextView = itemView.findViewById(R.id.textView4)
    }

    fun updateMenu(newMenu: List<MenuModel>) {
        listMenu = newMenu
        notifyDataSetChanged()
    }
}