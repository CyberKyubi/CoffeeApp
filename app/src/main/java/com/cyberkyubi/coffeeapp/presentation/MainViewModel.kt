package com.cyberkyubi.coffeeapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberkyubi.domain.model.CategoriesModel
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

    data class CategoryData(val title: String, var isActive: Boolean = false)
    private val beverageCategoryMutableLive = MutableLiveData<CategoryData>()
    private val foodCategoryMutableLive = MutableLiveData<CategoryData>()
    val beverageCategoryLive: LiveData<CategoryData> = beverageCategoryMutableLive
    val foodCategoryLive: LiveData<CategoryData> = foodCategoryMutableLive


    private enum class StateOfMenu {Initial, BeveragesMenu, FoodMenu}
    private var currentStateOfMenu: StateOfMenu = StateOfMenu.Initial

    init {
//        addNewCategories()
//        addNewMenu()

        getInitialMenu()
    }


     private fun addNewCategories() {
        viewModelScope.launch {
            addNewCategoriesUseCase.execute(
                listCategories = listOf(
                    CategoriesModel(categoryId = 0, title = "Напитки"),
                    CategoriesModel(categoryId = 0, title = "Еда"),
                )
            )
        }
    }

    private fun addNewMenu() {
        viewModelScope.launch {
            addNewMenu.execute(
                listMenu = listOf(
                    MenuModel(menuId = 0, categoryId = 1, title = "Весна и лето", drawableResourceName = "ic_coffee_cup.png"),
                    MenuModel(menuId = 0, categoryId = 1, title = "Горячий кофе", drawableResourceName = "ic_coffee_cup.png"),
                    MenuModel(menuId = 0, categoryId = 1, title = "Холодный кофе", drawableResourceName = "ic_coffee_cup.png"),
                    MenuModel(menuId = 0, categoryId = 1, title = "Охлаждающие напитки", drawableResourceName = "ic_coffee_cup.png"),

                    MenuModel(menuId = 0, categoryId = 2, title = "Десерты", drawableResourceName = "ic_sweets.png"),
                    MenuModel(menuId = 0, categoryId = 2, title = "Каши", drawableResourceName = "ic_sweets.png"),
                    MenuModel(menuId = 0, categoryId = 2, title = "Сендвичи", drawableResourceName = "ic_sweets.png"),
                    MenuModel(menuId = 0, categoryId = 2, title = "Спорт. питание", drawableResourceName = "ic_sweets.png"),
                )
            )
        }
    }

    private fun getInitialMenu() {
        viewModelScope.launch {
            val (firstCategory, secondCategory) = getCategoriesUseCase.execute()
            beverageCategoryMutableLive.value = CategoryData(title = firstCategory.title)
            foodCategoryMutableLive.value = CategoryData(title = secondCategory.title)
        }

        getBeveragesMenu()
    }

    fun getBeveragesMenu() {
        if (currentStateOfMenu != StateOfMenu.BeveragesMenu) {
            currentStateOfMenu = StateOfMenu.BeveragesMenu

            beverageCategoryMutableLive.value?.let {categoryData ->
                categoryData.isActive = true
                beverageCategoryMutableLive.value = categoryData
            }

            viewModelScope.launch {
                menuMutableLive.value = getBeveragesMenuUseCase.execute(categoryId = 1)
            }

        }
    }

    fun getFoodMenu() {
        if (currentStateOfMenu != StateOfMenu.FoodMenu) {
            currentStateOfMenu = StateOfMenu.FoodMenu


            foodCategoryMutableLive.value?.let {categoryData ->
                categoryData.isActive = true
                foodCategoryMutableLive.value = categoryData
            }

            viewModelScope.launch {
                menuMutableLive.value = getFoodMenuUseCase.execute(categoryId = 2)
            }
        }
    }

}