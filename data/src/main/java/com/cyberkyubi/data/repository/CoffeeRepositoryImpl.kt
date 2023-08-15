package com.cyberkyubi.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.cyberkyubi.data.dao.CoffeeDao
import com.cyberkyubi.data.mapper.CoffeeMapper.mapListCategoriesEntityToListCategoriesModel
import com.cyberkyubi.data.mapper.CoffeeMapper.mapListCategoriesModelToListCategoriesEntity
import com.cyberkyubi.data.mapper.CoffeeMapper.mapListMenuEntityToListMenuModel
import com.cyberkyubi.data.mapper.CoffeeMapper.mapListMenuModelToListMenuEntity
import com.cyberkyubi.domain.model.CategoriesModel
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
            return@withContext mapListMenuEntityToListMenuModel(coffeeDao.getMenuByCategoryId(categoryId))
        }
    }

    override suspend fun insertAllCategories(listCategories: List<CategoriesModel>) {
        coffeeDao.insertAllCategories(mapListCategoriesModelToListCategoriesEntity(listCategories))
    }

    override suspend fun insertAllMenu(listMenu: List<MenuModel>) {
        coffeeDao.insertAllMenu(mapListMenuModelToListMenuEntity(listMenu))
    }
}