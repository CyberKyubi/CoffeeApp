package com.cyberkyubi.coffeeapp.presentation.activity

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
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

        val beverageTextView = findViewById<TextView>(R.id.beverageTextView)
        val foodTextView = findViewById<TextView>(R.id.foodTextView)
        val dotDrawableBottom = AppCompatResources.getDrawable(this, R.drawable.dot)

        viewModel.beverageCategoryLive.observe(this) { beverageTextView.text = it }
        viewModel.foodCategoryLive.observe(this) { foodTextView.text = it }
        viewModel.stateOfMenuLive.observe(this) {stateOfMenu ->
            drawActiveMenu(
                stateOfMenu = stateOfMenu,
                beverageTextView = beverageTextView,
                foodTextView = foodTextView,
                dotDrawableBottom = dotDrawableBottom
            )
        }

        beverageTextView.setOnClickListener { viewModel.getBeverageMenu() }
        foodTextView.setOnClickListener { viewModel.getFoodMenu() }

        recyclerAdapter = MenuRecyclerAdapter(emptyList())
        viewModel.menuLive.observe(this) { recyclerAdapter.updateMenu(adapter = recyclerAdapter, it) }
        recyclerView = findViewById(R.id.menuRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = recyclerAdapter

    }

    private fun drawActiveMenu(
        stateOfMenu: StateOfMenu,
        beverageTextView: TextView,
        foodTextView: TextView,
        dotDrawableBottom: Drawable?
    ) {
        if (stateOfMenu == StateOfMenu.BeveragesMenu) {
            beverageTextView.setTextColor(this.getColor(R.color.biancaCream))
            beverageTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null, null, null, dotDrawableBottom
            )

            foodTextView.setTextColor(this.getColor(R.color.textViewBrown))
            foodTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null, null, null, null
            )
        } else if (stateOfMenu == StateOfMenu.FoodMenu) {
            foodTextView.setTextColor(this.getColor(R.color.biancaCream))
            foodTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null, null, null, dotDrawableBottom
            )

            beverageTextView.setTextColor(this.getColor(R.color.textViewBrown))
            beverageTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null, null, null, null
            )
        }
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