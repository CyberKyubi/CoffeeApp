package com.cyberkyubi.coffeeapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import com.cyberkyubi.domain.model.DrinkModel
import com.cyberkyubi.domain.model.MenuDetailsModel
import com.cyberkyubi.domain.usecase.GetDrinksListByMenuIdUseCase
import com.cyberkyubi.domain.usecase.GetMenuDetailsUseCase

class DrinksListViewModel(
    private val getMenuDetailsUseCase: GetMenuDetailsUseCase,
    private val getDrinksListByMenuIdUseCase: GetDrinksListByMenuIdUseCase
) : ViewModel() {

    private lateinit var menuDetailsModel: MenuDetailsModel

    private val menuTitleMutable = MutableLiveData<String>()
    private val menuDescriptionMutable = MutableLiveData<String>()
    private val drinksListMutableLive = MutableLiveData<List<DrinkModel>>()
    val menuTitleLive = menuTitleMutable
    val menuDescriptionLive = menuDescriptionMutable
    val drinksListLive = drinksListMutableLive


    fun setLiveData(menuId: Int) {
        viewModelScope.launch {
            menuDetailsModel = getMenuDetailsUseCase.execute(menuId)
            menuTitleMutable.value = menuDetailsModel.title
            menuDescriptionMutable.value = menuDetailsModel.description

            drinksListMutableLive.value = getDrinksListByMenuIdUseCase.execute(menuId = menuId)
        }
    }
}