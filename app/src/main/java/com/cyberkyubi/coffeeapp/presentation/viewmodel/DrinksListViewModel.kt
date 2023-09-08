package com.cyberkyubi.coffeeapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyberkyubi.coffeeapp.manager.IconManager
import kotlinx.coroutines.launch

import com.cyberkyubi.domain.model.DrinkModel
import com.cyberkyubi.domain.model.MenuDetailsModel
import com.cyberkyubi.domain.usecase.GetDrinksListByMenuIdUseCase
import com.cyberkyubi.domain.usecase.GetMenuDetailsUseCase

class DrinksListViewModel(
    private val iconManager: IconManager,
    private val getMenuDetailsUseCase: GetMenuDetailsUseCase,
    private val getDrinksListByMenuIdUseCase: GetDrinksListByMenuIdUseCase
) : ViewModel() {

    private lateinit var _menuDetailsModel: MenuDetailsModel

    private val _menuTitleLive = MutableLiveData<String>()
    private val _menuDescriptionLive = MutableLiveData<String>()
    private val _drinksListLive = MutableLiveData<List<DrinkModel>>()
    val menuTitleLive = _menuTitleLive
    val menuDescriptionLive = _menuDescriptionLive
    val drinksListLive = _drinksListLive


    fun setLiveData(menuId: Int) {
        viewModelScope.launch {
            _menuDetailsModel = getMenuDetailsUseCase.execute(menuId)
            _menuTitleLive.value = _menuDetailsModel.title
            _menuDescriptionLive.value = _menuDetailsModel.description

            val drinksList = getDrinksListByMenuIdUseCase.execute(menuId = menuId)
            _drinksListLive.value = drinksList

            Log.e("scope", drinksList.toString())

            drinksList.forEach { drink ->
                drink.ingredients = drink.ingredients.mapNotNull { ingredientId ->
                    iconManager.icons[ingredientId]
                }
            }

            Log.e("scope", drinksList.toString())
        }
    }
}