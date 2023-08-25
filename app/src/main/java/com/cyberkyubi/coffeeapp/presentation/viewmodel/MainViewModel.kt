package com.cyberkyubi.coffeeapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import com.cyberkyubi.domain.model.MenuModel
import com.cyberkyubi.domain.usecase.GetBeverageMenuUseCase
import com.cyberkyubi.domain.usecase.GetCategoriesUseCase
import com.cyberkyubi.domain.usecase.GetFoodMenuUseCase

enum class StateOfMenu {
    Initial,
    BeveragesMenu,
    FoodsMenu,
    ProductsMenu
}

class MainViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getBeverageMenuUseCase: GetBeverageMenuUseCase,
    private val getFoodMenuUseCase: GetFoodMenuUseCase
) : ViewModel() {

    private val beverageCategoryMutableLive = MutableLiveData<String>()
    private val foodCategoryMutableLive = MutableLiveData<String>()
    private val productCategoryMutableLive = MutableLiveData<String>()
    val beverageCategoryLive: LiveData<String> = beverageCategoryMutableLive
    val foodCategoryLive: LiveData<String> = foodCategoryMutableLive
    val productCategoryLive: LiveData<String> = productCategoryMutableLive

    private val menuMutableLive = MutableLiveData<List<MenuModel>>()
    val menuLive: LiveData<List<MenuModel>> = menuMutableLive

    private var currentStateOfMenuMutableLiveData = MutableLiveData(StateOfMenu.Initial)
    val stateOfMenuLive: LiveData<StateOfMenu> = currentStateOfMenuMutableLiveData

    init {
        getInitialMenu()
    }

    private fun getInitialMenu() {
        viewModelScope.launch {
            val (beverageCategory, foodCategory, productCategory) = getCategoriesUseCase.execute()
            beverageCategoryMutableLive.value = beverageCategory.title
            foodCategoryMutableLive.value = foodCategory.title
            productCategoryMutableLive.value = productCategory.title
        }

        getBeverageMenu()
    }

    fun getBeverageMenu() {
        if (currentStateOfMenuMutableLiveData.value != StateOfMenu.BeveragesMenu) {
            currentStateOfMenuMutableLiveData.value = StateOfMenu.BeveragesMenu

            viewModelScope.launch {
                menuMutableLive.value = getBeverageMenuUseCase.execute(categoryId = 1)
            }

        }
    }

    fun getFoodMenu() {
        if (currentStateOfMenuMutableLiveData.value != StateOfMenu.FoodsMenu) {
            currentStateOfMenuMutableLiveData.value = StateOfMenu.FoodsMenu

            viewModelScope.launch {
                menuMutableLive.value = getFoodMenuUseCase.execute(categoryId = 2)
            }
        }
    }

    fun getProductMenu() {
        if (currentStateOfMenuMutableLiveData.value != StateOfMenu.ProductsMenu) {
            currentStateOfMenuMutableLiveData.value = StateOfMenu.ProductsMenu


        }
    }
}