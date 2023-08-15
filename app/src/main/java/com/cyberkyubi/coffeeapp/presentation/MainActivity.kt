package com.cyberkyubi.coffeeapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.GridView
import com.cyberkyubi.coffeeapp.R
import com.cyberkyubi.coffeeapp.adapter.MenuGridViewAdapter
import com.cyberkyubi.coffeeapp.databinding.ActivityMainBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    private lateinit var gridView: GridView
    private lateinit var gridViewAdapter: MenuGridViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        gridView = findViewById(R.id.menuGridView)
        gridViewAdapter = MenuGridViewAdapter(this, emptyList())
        gridView.adapter = gridViewAdapter

        viewModel.menuLive.observe(this) {
            gridViewAdapter.updateMenu(it)
        }


        val beveragesButton = findViewById<Button>(R.id.beveragesButton)
        val foodButton = findViewById<Button>(R.id.foodButton)

        viewModel.firstCategoryLive.observe(this) {
            beveragesButton.text = it
        }
        beveragesButton.setOnClickListener {
            viewModel.getBeveragesMenu()
        }

        viewModel.secondCategoryLive.observe(this) {
            foodButton.text = it
        }

        foodButton.setOnClickListener {
            viewModel.getFoodMenu()
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