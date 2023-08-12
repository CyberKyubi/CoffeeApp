package com.cyberkyubi.coffeeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.cyberkyubi.coffeeapp.R
import com.cyberkyubi.domain.model.CardOfProductMenuModel

class MenuGridViewAdapter(
    private var context: Context,
    private var data: List<CardOfProductMenuModel>
): BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position].title
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

        }

        holder.textView.text = getItem(position).toString()
        return view
    }

    private class ViewHolder(itemView: View) {
        val cardOfProduct: CardView = itemView.findViewById(R.id.cardOfProduct)
        val textView: TextView = itemView.findViewById(R.id.textView4)
    }

    fun updateMenu(newMenu: List<CardOfProductMenuModel>) {
        data = newMenu
        notifyDataSetChanged()
    }
}