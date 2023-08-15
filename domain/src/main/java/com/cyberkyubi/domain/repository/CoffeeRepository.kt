package com.cyberkyubi.domain.repository

import com.cyberkyubi.domain.model.CategoriesModel
import com.cyberkyubi.domain.model.MenuModel

interface CoffeeRepository {

    suspend fun getCategories(): List<CategoriesModel>

    suspend fun getMenuByCategoryId(categoryId: Int): List<MenuModel>

    suspend fun insertAllCategories(listCategories: List<CategoriesModel>)

    suspend fun insertAllMenu(listMenu: List<MenuModel>)
}