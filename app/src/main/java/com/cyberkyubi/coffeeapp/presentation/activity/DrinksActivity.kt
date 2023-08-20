package com.cyberkyubi.coffeeapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import com.cyberkyubi.coffeeapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.cyberkyubi.coffeeapp.databinding.ActivityDrinksBinding
import com.cyberkyubi.coffeeapp.presentation.viewmodel.DrinksViewModel
import com.cyberkyubi.coffeeapp.adapter.DrinksGridAdapter

class DrinksActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrinksBinding
    private val viewModel: DrinksViewModel by viewModel()

    private lateinit var gridView: GridView
    private lateinit var gridAdapter: DrinksGridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrinksBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val bundle = intent.extras
        if (bundle != null) {
            viewModel.setLiveData(
                menuId = bundle.getInt("menu_id"),
                titleMenu = bundle.getString("title_menu", "Меню")
            )
        }

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        val pageTitleTextView = findViewById<TextView>(R.id.pageTitle)
        viewModel.titleMenuLive.observe(this) {pageTitleTextView.text = it }

        gridView = findViewById(R.id.drinksGridView)
        gridAdapter = DrinksGridAdapter(this, emptyList())
        gridView.adapter = gridAdapter

        viewModel.drinkMenuLive.observe(this) { gridAdapter.updateDrinks(it) }
    }

    override fun onStart() {
        super.onStart()

        Log.e("Activity", "DrinksActivity onStart")

    }

    override fun onResume() {
        super.onResume()

        Log.e("Activity", "DrinksActivity OnResume")
    }


    override fun onPause() {
        super.onPause()

        Log.e("Activity", "DrinksActivity onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.e("Activity", "DrinksActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.e("Activity", "DrinksActivity onRestart")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("Activity", "DrinksActivity onDestroy")

    }
}