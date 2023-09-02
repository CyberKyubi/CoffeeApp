package com.cyberkyubi.coffeeapp.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.cyberkyubi.coffeeapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.cyberkyubi.coffeeapp.databinding.ActivityDrinksListBinding
import com.cyberkyubi.coffeeapp.presentation.viewmodel.DrinksViewModel

class DrinksListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDrinksListBinding
    private val viewModel: DrinksViewModel by viewModel()


    // todo выводить название, иконки ингридиентов, цену, кнопку плюса
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrinksListBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val bundle = intent.extras
        if (bundle != null) {
            viewModel.setLiveData(menuId = bundle.getInt("menu_id"))
        }

        val backButton = findViewById<ImageView>(R.id.back_button_image)
        backButton.setOnClickListener { onBackPressedDispatcher.onBackPressed() }

        val menuTitleTextView = findViewById<TextView>(R.id.menu_title_text)
        val menuDescriptionTextView = findViewById<TextView>(R.id.menu_description_text)
        viewModel.menuTitleLive.observe(this) { menuTitleTextView.text = it }
        viewModel.menuDescriptionLive.observe(this) {menuDescriptionTextView.text = it }

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