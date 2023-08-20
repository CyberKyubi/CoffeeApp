package com.cyberkyubi.coffeeapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.cyberkyubi.coffeeapp.R

import com.cyberkyubi.coffeeapp.databinding.ActivityDrinkDetailsActityBinding
import com.cyberkyubi.coffeeapp.presentation.viewmodel.DrinkDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DrinkDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrinkDetailsActityBinding
    private val viewModel: DrinkDetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrinkDetailsActityBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val drinkImage = findViewById<ImageView>(R.id.drinkImage)
        val drinkName = findViewById<TextView>(R.id.drinkName)
    }
}