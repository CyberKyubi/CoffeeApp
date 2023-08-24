package com.cyberkyubi.coffeeapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cyberkyubi.coffeeapp.R

import com.cyberkyubi.coffeeapp.presentation.activity.DrinksListActivity
import com.cyberkyubi.domain.model.MenuModel

class MenuRecyclerAdapter(
    private var menu: List<MenuModel>
): RecyclerView.Adapter<MenuRecyclerAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardMenu: CardView = itemView.findViewById(R.id.cardMenu)
        val drawableResource: ImageView = itemView.findViewById(R.id.iconMenu)
        val titleMenu: TextView = itemView.findViewById(R.id.titleMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_menu, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun getItemCount() = menu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item: MenuModel = menu[position]

        holder.cardMenu.setOnClickListener {
            setOnClickListener(context = holder.itemView.context, item = item)
        }

        val drawable = when (item.categoryId) {
            1 -> AppCompatResources.getDrawable(holder.itemView.context, R.drawable.ic_coffee_drinks)
            2 -> AppCompatResources.getDrawable(holder.itemView.context, R.drawable.ic_sweets)
            else -> {
                AppCompatResources.getDrawable(holder.itemView.context, R.drawable.ic_warning)
            }
        }

        holder.drawableResource.setImageDrawable(drawable)
        holder.titleMenu.text = item.title
    }

    fun updateMenu(adapter: MenuRecyclerAdapter, newMenu: List<MenuModel>) {
        menu = newMenu
        adapter.notifyDataSetChanged()
    }

    private fun setOnClickListener(context: Context, item: MenuModel) {
        when (item.categoryId) {
            1 -> startDrinksActivity(context = context, menuModel = item)
            2 -> startFoodsActivity(context = context, menuModel = item)
        }
    }

    private fun startDrinksActivity(context: Context, menuModel: MenuModel) {
        val intent = Intent(context, DrinksListActivity::class.java)
        startActivity(context = context, intent = intent, menuModel = menuModel)
    }

    private fun startFoodsActivity(context: Context, menuModel: MenuModel) {
        // TODO: FoodsActivity
        val intent = Intent(context, DrinksListActivity::class.java)
        startActivity(context = context, intent = intent, menuModel = menuModel)
    }

    private fun startActivity(context: Context, intent: Intent, menuModel: MenuModel) {
        intent.putExtra("menu_id", menuModel.menuId)
        intent.putExtra("title_menu", menuModel.title)
        context.startActivity(intent)
    }
}