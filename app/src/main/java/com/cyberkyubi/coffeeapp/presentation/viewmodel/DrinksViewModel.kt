package com.cyberkyubi.coffeeapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import com.cyberkyubi.domain.model.DrinkModel
import com.cyberkyubi.domain.model.MenuDetailsModel
import com.cyberkyubi.domain.usecase.GetDrinkMenuByIdUseCase
import com.cyberkyubi.domain.usecase.GetMenuDetailsUseCase

class DrinksViewModel(
    private val getMenuDetailsUseCase: GetMenuDetailsUseCase,
    private val getDrinkMenuByIdUseCase: GetDrinkMenuByIdUseCase
) : ViewModel() {

    private lateinit var menuDetailsModel: MenuDetailsModel

    private val menuTitleMutable = MutableLiveData<String>()
    private val menuDescriptionMutable = MutableLiveData<String>()
    private val drinksMenuMutableLive = MutableLiveData<List<DrinkModel>>()
    val menuTitleLive = menuTitleMutable
    val menuDescriptionLive = menuDescriptionMutable
    val drinksMenuLive = drinksMenuMutableLive


    fun setLiveData(menuId: Int) {
        viewModelScope.launch {
            menuDetailsModel = getMenuDetailsUseCase.execute(menuId)
            menuTitleMutable.value = menuDetailsModel.title
            menuDescriptionMutable.value = menuDetailsModel.description
        }

//        getDrinkMenu()
    }

    private fun getDrinkMenu() {
//        viewModelScope.launch {
//            drinksMenuMutableLive.value = menuIdMutableLive.value?.let {
//                getDrinkMenuByIdUseCase.execute(menuId = it)
//            }
//        }
    }

}