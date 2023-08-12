package com.cyberkyubi.coffeeapp.presentation

import android.util.Log
import android.widget.GridView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cyberkyubi.coffeeapp.adapter.MenuGridViewAdapter

class MainViewModel: ViewModel() {

    private val menuLiveMutable = MutableLiveData<List<String>>()
    val menuLive: LiveData<List<String>> = menuLiveMutable

    init {
        getInitialMenu()
    }

    private fun getInitialMenu() {
        menuLiveMutable.value = listOf("капучино", "латте")
    }

    fun getBeveragesMenu() {

    }

    fun getFoodMenu() {

    }

}