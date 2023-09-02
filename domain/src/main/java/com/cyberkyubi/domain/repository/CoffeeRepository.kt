package com.cyberkyubi.domain.repository

import com.cyberkyubi.domain.model.CategoriesModel
import com.cyberkyubi.domain.model.DrinkModel
import com.cyberkyubi.domain.model.FoodModel
import com.cyberkyubi.domain.model.MenuDetailsModel
import com.cyberkyubi.domain.model.MenuModel

interface CoffeeRepository {

    suspend fun getCategories(): List<CategoriesModel>

    suspend fun getMenuByCategoryId(categoryId: Int): List<MenuModel>

    suspend fun getMenuDetailsById(menuId: Int): MenuDetailsModel

    suspend fun getDrinkMenuById(menuId: Int): List<DrinkModel>

    suspend fun getFoodMenuById(menuId: Int): List<FoodModel>
}

