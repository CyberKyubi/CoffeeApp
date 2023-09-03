package com.cyberkyubi.coffeeapp.presentation.activity

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cyberkyubi.coffeeapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.cyberkyubi.coffeeapp.adapter.MenuRecyclerAdapter
import com.cyberkyubi.coffeeapp.databinding.ActivityMainBinding
import com.cyberkyubi.coffeeapp.presentation.viewmodel.MainViewModel
import com.cyberkyubi.coffeeapp.presentation.viewmodel.StateOfMenu

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: MenuRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val beveragesTextView = findViewById<TextView>(R.id.beverages_text)
        val foodsTextView = findViewById<TextView>(R.id.foods_text)
        val productsTextView = findViewById<TextView>(R.id.products_text)
        val dotDrawableBottom = AppCompatResources.getDrawable(this, R.drawable.dot)

        viewModel.beverageCategoryLive.observe(this) { beveragesTextView.text = it }
        viewModel.foodCategoryLive.observe(this) { foodsTextView.text = it }
        viewModel.productCategoryLive.observe(this) {productsTextView.text = it}
        viewModel.stateOfMenuLive.observe(this) {stateOfMenu ->

            setMenuStyle(beveragesTextView, isActive = false, dotDrawableBottom = null)
            setMenuStyle(foodsTextView, isActive = false, dotDrawableBottom = null)
            setMenuStyle(productsTextView, isActive = false, dotDrawableBottom = null)

            when (stateOfMenu) {
                StateOfMenu.BeveragesMenu -> {
                    setMenuStyle(beveragesTextView, isActive = true, dotDrawableBottom)
                }
                StateOfMenu.FoodsMenu -> {
                    setMenuStyle(foodsTextView, isActive = true, dotDrawableBottom)
                }
                StateOfMenu.ProductsMenu -> {
                    setMenuStyle(productsTextView, isActive = true, dotDrawableBottom)
                }

                else -> {}
            }
        }

        beveragesTextView.setOnClickListener { viewModel.getBeverageMenu() }
        foodsTextView.setOnClickListener { viewModel.getFoodMenu() }
        productsTextView.setOnClickListener { viewModel.getProductMenu() }

        recyclerAdapter = MenuRecyclerAdapter(emptyList())
        viewModel.menuLive.observe(this) { recyclerAdapter.updateMenu(it) }
        recyclerView = findViewById(R.id.menu_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = recyclerAdapter
    }

    private fun setMenuStyle(menuTextView: TextView, isActive: Boolean, dotDrawableBottom: Drawable?) {
        var color: Int = R.color.text_view_brown
        var drawable: Drawable? = null

        if (isActive) {
            color = R.color.bianca_cream
            drawable = dotDrawableBottom
        }

        menuTextView.setTextColor(this.getColor(color))
        menuTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
            null, null, null, drawable
        )
    }


    override fun onStart() {
        super.onStart()

        Log.e("Activity", "MainActivity onStart")

    }

    override fun onResume() {
        super.onResume()

        Log.e("Activity", "MainActivity OnResume")
    }


    override fun onPause() {
        super.onPause()

        Log.e("Activity", "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.e("Activity", "MainActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.e("Activity", "MainActivity onRestart")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("Activity", "MainActivity onDestroy")

    }
}