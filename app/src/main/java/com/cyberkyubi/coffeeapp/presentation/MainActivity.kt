package com.cyberkyubi.coffeeapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.cyberkyubi.coffeeapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.cyberkyubi.coffeeapp.adapter.MenuGridViewAdapter
import com.cyberkyubi.coffeeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    private lateinit var gridView: GridView
    private lateinit var gridViewAdapter: MenuGridViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val beverageTextView = findViewById<TextView>(R.id.beverageTextView)
        val foodTextView = findViewById<TextView>(R.id.foodTextView)
        val dotDrawableBottom = AppCompatResources.getDrawable(this, R.drawable.dot)

        viewModel.beverageCategoryLive.observe(this) { beverageTextView.text = it }
        viewModel.foodCategoryLive.observe(this) { foodTextView.text = it }

        viewModel.stateOfMenuLive.observe(this) {stateOfMenu ->
            if (stateOfMenu == StateOfMenu.BeveragesMenu) {
                beverageTextView.setTextColor(this.getColor(R.color.textViewBrown))
                beverageTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null, null, null, dotDrawableBottom
                )

                foodTextView.setTextColor(this.getColor(R.color.textViewGray))
                foodTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null, null, null, null
                )
            } else if (stateOfMenu == StateOfMenu.FoodMenu) {
                foodTextView.setTextColor(this.getColor(R.color.textViewBrown))
                foodTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null, null, null, dotDrawableBottom
                )

                beverageTextView.setTextColor(this.getColor(R.color.textViewGray))
                beverageTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null, null, null, null
                )
            }
        }

        beverageTextView.setOnClickListener { viewModel.getBeverageMenu() }
        foodTextView.setOnClickListener { viewModel.getFoodMenu() }


        gridView = findViewById(R.id.menuGridView)
        gridViewAdapter = MenuGridViewAdapter(this, emptyList())
        gridView.adapter = gridViewAdapter

        viewModel.menuLive.observe(this) { gridViewAdapter.updateMenu(it) }

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