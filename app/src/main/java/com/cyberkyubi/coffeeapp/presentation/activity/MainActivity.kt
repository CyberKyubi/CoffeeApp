package com.cyberkyubi.coffeeapp.presentation.activity

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
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

        val beverageTextView = findViewById<TextView>(R.id.beverageTextView)
        val foodTextView = findViewById<TextView>(R.id.foodTextView)
        val productTextView = findViewById<TextView>(R.id.productTextView)
        val dotDrawableBottom = AppCompatResources.getDrawable(this, R.drawable.dot)

        viewModel.beverageCategoryLive.observe(this) { beverageTextView.text = it }
        viewModel.foodCategoryLive.observe(this) { foodTextView.text = it }
        viewModel.productCategoryLive.observe(this) {productTextView.text = it}
        viewModel.stateOfMenuLive.observe(this) {stateOfMenu ->

            setMenuStyle(beverageTextView, isActive = false, dotDrawableBottom = null)
            setMenuStyle(foodTextView, isActive = false, dotDrawableBottom = null)
            setMenuStyle(productTextView, isActive = false, dotDrawableBottom = null)

            when (stateOfMenu) {
                StateOfMenu.BeveragesMenu -> {
                    setMenuStyle(beverageTextView, isActive = true, dotDrawableBottom)
                }
                StateOfMenu.FoodsMenu -> {
                    setMenuStyle(foodTextView, isActive = true, dotDrawableBottom)
                }
                StateOfMenu.ProductsMenu -> {
                    setMenuStyle(productTextView, isActive = true, dotDrawableBottom)
                }

                else -> {}
            }
        }

        beverageTextView.setOnClickListener { viewModel.getBeverageMenu() }
        foodTextView.setOnClickListener { viewModel.getFoodMenu() }
        productTextView.setOnClickListener { viewModel.getProductMenu() }

        recyclerAdapter = MenuRecyclerAdapter(emptyList())
        viewModel.menuLive.observe(this) { recyclerAdapter.updateMenu(adapter = recyclerAdapter, it) }
        recyclerView = findViewById(R.id.menuRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = recyclerAdapter

    }

    private fun setMenuStyle(menuTextView: TextView, isActive: Boolean, dotDrawableBottom: Drawable?) {
        var color: Int = R.color.textViewBrown
        var drawable: Drawable? = null

        if (isActive) {
            color = R.color.biancaCream
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