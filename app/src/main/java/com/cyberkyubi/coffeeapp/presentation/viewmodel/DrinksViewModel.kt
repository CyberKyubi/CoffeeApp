package com.cyberkyubi.coffeeapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import com.cyberkyubi.domain.model.DrinkModel
import com.cyberkyubi.domain.usecase.GetDrinkMenuByIdUseCase

class DrinksViewModel(
    private val getDrinkMenuByIdUseCase: GetDrinkMenuByIdUseCase
) : ViewModel() {

    private val menuIdMutableLive = MutableLiveData<Int>()
    private val titleMenuMutableLive = MutableLiveData<String>()
    private val drinkMenuMutableLive = MutableLiveData<List<DrinkModel>>()
    val titleMenuLive = titleMenuMutableLive
    val drinkMenuLive = drinkMenuMutableLive

    fun setLiveData(menuId: Int, titleMenu: String) {
        menuIdMutableLive.value = menuId
        titleMenuMutableLive.value = titleMenu

        getDrinkMenu()
    }

    private fun getDrinkMenu() {
        viewModelScope.launch {
            drinkMenuMutableLive.value = menuIdMutableLive.value?.let {
                getDrinkMenuByIdUseCase.execute(menuId = it)
            }
        }
    }

}