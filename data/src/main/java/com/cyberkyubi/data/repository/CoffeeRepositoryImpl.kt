package com.cyberkyubi.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.cyberkyubi.data.dao.CoffeeDao
import com.cyberkyubi.data.mapper.CoffeeMapper.mapListCategoriesEntityToListCategoriesModel
import com.cyberkyubi.data.mapper.CoffeeMapper.mapListDrinksEntityToListDrinkModel
import com.cyberkyubi.data.mapper.CoffeeMapper.mapListFoodsEntityToListFoodModel
import com.cyberkyubi.data.mapper.CoffeeMapper.mapListMenuEntityToListMenuModel
import com.cyberkyubi.domain.model.CategoriesModel
import com.cyberkyubi.domain.model.DrinkModel
import com.cyberkyubi.domain.model.FoodModel
import com.cyberkyubi.domain.model.MenuModel
import com.cyberkyubi.domain.repository.CoffeeRepository

class CoffeeRepositoryImpl(private val coffeeDao: CoffeeDao): CoffeeRepository {

    override suspend fun getCategories(): List<CategoriesModel> {
        return withContext(Dispatchers.IO) {
            return@withContext mapListCategoriesEntityToListCategoriesModel(coffeeDao.getCategories())
        }
    }

    override suspend fun getMenuByCategoryId(categoryId: Int): List<MenuModel>  {
        return withContext(Dispatchers.IO) {
            return@withContext mapListMenuEntityToListMenuModel(
                coffeeDao.getMenuByCategoryId(categoryId = categoryId)
            )
        }
    }

    override suspend fun getDrinkMenuById (menuId: Int): List<DrinkModel> {
        return withContext(Dispatchers.IO) {
            return@withContext mapListDrinksEntityToListDrinkModel(
                coffeeDao.getDrinkMenuById(menuId = menuId)
            )
        }
    }

    override suspend fun getFoodMenuById (menuId: Int): List<FoodModel> {
        return withContext(Dispatchers.IO) {
            return@withContext mapListFoodsEntityToListFoodModel(
                coffeeDao.getFoodMenuById(menuId = menuId)
            )
        }
    }
}