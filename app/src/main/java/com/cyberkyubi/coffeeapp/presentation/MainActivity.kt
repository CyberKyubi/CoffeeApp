package com.cyberkyubi.coffeeapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import androidx.lifecycle.Observer
import com.cyberkyubi.coffeeapp.R
import com.cyberkyubi.coffeeapp.adapter.MenuGridViewAdapter
import com.cyberkyubi.coffeeapp.databinding.ActivityMainBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel<MainViewModel>()


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

        beveragesButton.setOnClickListener {
            viewModel.getBeveragesMenu()
        }

        foodButton.setOnClickListener {
            viewModel.getFoodMenu()
        }

    }
}