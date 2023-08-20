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

import com.cyberkyubi.coffeeapp.presentation.activity.DrinksActivity
import com.cyberkyubi.domain.model.MenuModel

class MainGridAdapter(
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
            view = inflater.inflate(R.layout.gridview_menu, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val item = getItem(position)

        holder.cardMenu.setOnClickListener {
            when (item.categoryId) {
                1 -> startDrinksActivity(menuModel = item)
                2 -> startFoodsActivity(menuModel = item)
            }

        }

        val drawable = when (item.categoryId) {
            1 -> AppCompatResources.getDrawable(context, R.drawable.ic_coffee_cup)
            2 -> AppCompatResources.getDrawable(context, R.drawable.ic_sweets)
            else -> {
                AppCompatResources.getDrawable(context, R.drawable.ic_warning)
            }
        }
        holder.drawableResource.setImageDrawable(drawable)
        holder.titleMenu.text = item.title
        return view
    }

    private class ViewHolder(itemView: View) {
        val cardMenu: CardView = itemView.findViewById(R.id.cardMenu)
        val drawableResource: ImageView = itemView.findViewById(R.id.iconMenu)
        val titleMenu: TextView = itemView.findViewById(R.id.titleMenu)
    }

    fun updateMenu(newMenu: List<MenuModel>) {
        listMenu = newMenu
        notifyDataSetChanged()
    }

    private fun startDrinksActivity(menuModel: MenuModel) {
        val intent = Intent(context, DrinksActivity::class.java)
        startActivity(intent = intent, menuModel = menuModel)
    }

    private fun startFoodsActivity(menuModel: MenuModel) {
        // TODO: FoodsActivity
        val intent = Intent(context, DrinksActivity::class.java)
        startActivity(intent = intent, menuModel = menuModel)
    }

    private fun startActivity(intent: Intent, menuModel: MenuModel) {
        intent.putExtra("menu_id", menuModel.menuId)
        intent.putExtra("title_menu", menuModel.title)
        context.startActivity(intent)
    }
}