package com.cyberkyubi.coffeeapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cyberkyubi.domain.model.CardOfProductMenuModel
import com.cyberkyubi.domain.usecase.GetBeveragesMenuUseCase
import com.cyberkyubi.domain.usecase.GetFoodMenuUseCase

class MainViewModel(
    private val getBeveragesMenuUseCase: GetBeveragesMenuUseCase,
    private val getFoodMenuUseCase: GetFoodMenuUseCase
) : ViewModel() {

    private val menuLiveMutable = MutableLiveData<List<CardOfProductMenuModel>>()
    val menuLive: LiveData<List<CardOfProductMenuModel>> = menuLiveMutable

    private enum class StateOfMenu {Initial, BeveragesMenu, FoodMenu}
    private var currentStateOfMenu: StateOfMenu = StateOfMenu.Initial

    init {
        getInitialMenu()
    }

    private fun getInitialMenu() {
        getBeveragesMenu()
    }

    fun getBeveragesMenu() {
        if (currentStateOfMenu != StateOfMenu.BeveragesMenu) {
            currentStateOfMenu = StateOfMenu.BeveragesMenu
            menuLiveMutable.value = getBeveragesMenuUseCase.execute()

            Log.e("btnckick", "beverages click")
        }
    }

    fun getFoodMenu() {
        if (currentStateOfMenu != StateOfMenu.FoodMenu) {
            currentStateOfMenu = StateOfMenu.FoodMenu
            menuLiveMutable.value = getFoodMenuUseCase.execute()

            Log.e("btnckick", "food click")
        }
    }

}