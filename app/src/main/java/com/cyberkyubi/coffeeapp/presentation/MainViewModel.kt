package com.cyberkyubi.coffeeapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import com.cyberkyubi.domain.model.MenuModel
import com.cyberkyubi.domain.usecase.AddNewCategoriesUseCase
import com.cyberkyubi.domain.usecase.AddNewMenu
import com.cyberkyubi.domain.usecase.GetBeveragesMenuUseCase
import com.cyberkyubi.domain.usecase.GetCategoriesUseCase
import com.cyberkyubi.domain.usecase.GetFoodMenuUseCase

class MainViewModel(
    private val addNewCategoriesUseCase: AddNewCategoriesUseCase,
    private val addNewMenu: AddNewMenu,

    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getBeveragesMenuUseCase: GetBeveragesMenuUseCase,
    private val getFoodMenuUseCase: GetFoodMenuUseCase
) : ViewModel() {

    private val menuMutableLive = MutableLiveData<List<MenuModel>>()
    val menuLive: LiveData<List<MenuModel>> = menuMutableLive

    private val firstCategoryMutableLive = MutableLiveData<String>()
    private val secondCategoryMutableLive = MutableLiveData<String>()
    val firstCategoryLive: LiveData<String> = firstCategoryMutableLive
    val secondCategoryLive: LiveData<String> = secondCategoryMutableLive


    private enum class StateOfMenu {Initial, BeveragesMenu, FoodMenu}
    private var currentStateOfMenu: StateOfMenu = StateOfMenu.Initial

    init {
//        addNewCategories()
//        addNewMenu()

        getInitialMenu()
    }


//     private fun addNewCategories() {
//        viewModelScope.launch {
//            addNewCategoriesUseCase.execute(
//                listCategories = listOf(
//                    CategoriesModel(categoryId = 0, title = "Напитки"),
//                    CategoriesModel(categoryId = 0, title = "Еда"),
//                )
//            )
//        }
//    }

//    private fun addNewMenu() {
//        viewModelScope.launch {
//            addNewMenu.execute(
//                listMenu = listOf(
//                    MenuModel(menuId = 0, categoryId = 1, title = "Весна и лето", drawableResourceName = "ic_coffee_cup.png"),
//                    MenuModel(menuId = 0, categoryId = 1, title = "Горячий кофе", drawableResourceName = "ic_coffee_cup.png"),
//                    MenuModel(menuId = 0, categoryId = 1, title = "Холодный кофе", drawableResourceName = "ic_coffee_cup.png"),
//                    MenuModel(menuId = 0, categoryId = 1, title = "Охлаждающие напитки", drawableResourceName = "ic_coffee_cup.png"),
//
//                    MenuModel(menuId = 0, categoryId = 2, title = "Десерты", drawableResourceName = "ic_sweets.png"),
//                    MenuModel(menuId = 0, categoryId = 2, title = "Каши", drawableResourceName = "ic_sweets.png"),
//                    MenuModel(menuId = 0, categoryId = 2, title = "Сендвичи", drawableResourceName = "ic_sweets.png"),
//                    MenuModel(menuId = 0, categoryId = 2, title = "Спорт. питание", drawableResourceName = "ic_sweets.png"),
//                )
//            )
//        }
//    }

    private fun getInitialMenu() {
        viewModelScope.launch {
            val (firstCategory, secondCategory) = getCategoriesUseCase.execute()
            firstCategoryMutableLive.value = firstCategory.title
            secondCategoryMutableLive.value = secondCategory.title
        }

        getBeveragesMenu()
    }

    fun getBeveragesMenu() {
        if (currentStateOfMenu != StateOfMenu.BeveragesMenu) {
            currentStateOfMenu = StateOfMenu.BeveragesMenu
            viewModelScope.launch {
                menuMutableLive.value = getBeveragesMenuUseCase.execute(categoryId = 1)
            }

        }
    }

    fun getFoodMenu() {
        if (currentStateOfMenu != StateOfMenu.FoodMenu) {
            currentStateOfMenu = StateOfMenu.FoodMenu
            viewModelScope.launch {
                menuMutableLive.value = getFoodMenuUseCase.execute(categoryId = 2)
            }
        }
    }

}