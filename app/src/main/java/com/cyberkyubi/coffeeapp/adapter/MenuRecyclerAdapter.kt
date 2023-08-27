package com.cyberkyubi.coffeeapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.cyberkyubi.coffeeapp.R

import com.cyberkyubi.coffeeapp.presentation.activity.DrinksListActivity
import com.cyberkyubi.domain.model.MenuModel

class MenuRecyclerAdapter(private var menu: List<MenuModel>): RecyclerView.Adapter<MenuRecyclerAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val drawableResource: ImageView = itemView.findViewById(R.id.menu_image_view)
        val menuTitle: TextView = itemView.findViewById(R.id.menu_title_text_view)
        val seasonalSpecials: TextView = itemView.findViewById(R.id.seasonal_specials_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_menu, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun getItemCount() = menu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item: MenuModel = menu[position]

//        holder.cardMenu.setOnClickListener {
//            setOnClickListener(context = holder.itemView.context, item = item)
//        }

        val drawable = when (item.categoryId) {
            1 -> AppCompatResources.getDrawable(holder.itemView.context, R.drawable.ic_coffee_drinks)
            2 -> AppCompatResources.getDrawable(holder.itemView.context, R.drawable.ic_desserts)
            else -> {
                AppCompatResources.getDrawable(holder.itemView.context, R.drawable.ic_coffee_drinks)
            }
        }

        holder.seasonalSpecials.text = null
        // TODO("it's hardcode")
        if (item.title == "Весна и лето") {
            holder.seasonalSpecials.text = holder.itemView.context.getString(R.string.seasonal_specials)
        }

        holder.drawableResource.setImageDrawable(drawable)
        holder.menuTitle.text = item.title
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