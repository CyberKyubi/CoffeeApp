package com.cyberkyubi.coffeeapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.cyberkyubi.coffeeapp.R
import com.cyberkyubi.coffeeapp.databinding.ActivityMainBinding
import com.cyberkyubi.coffeeapp.databinding.ActivityProductListingBinding

class ProductListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListingBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.e("Activity", "ProductListingActivity onStart")

    }

    override fun onResume() {
        super.onResume()

        Log.e("Activity", "ProductListingActivity OnResume")
    }


    override fun onPause() {
        super.onPause()

        Log.e("Activity", "ProductListingActivity onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.e("Activity", "ProductListingActivity onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.e("Activity", "ProductListingActivity onRestart")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("Activity", "ProductListingActivity onDestroy")

    }
}