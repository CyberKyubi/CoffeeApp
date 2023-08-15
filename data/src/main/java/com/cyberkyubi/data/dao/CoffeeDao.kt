package com.cyberkyubi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.cyberkyubi.data.entity.lower_level.CategoriesEntity
import com.cyberkyubi.data.entity.lower_level.MenuEntity

@Dao
interface CoffeeDao {

    @Query("SELECT category_id, title FROM categories")
    suspend fun getCategories(): List<CategoriesEntity>

    @Query("SELECT menu_id, title, category_id, drawable_resource_name FROM menu WHERE category_id = :categoryId")
    suspend fun getMenuByCategoryId(categoryId: Int): List<MenuEntity>

    @Insert
    suspend fun insertAllCategories(listCategories: List<CategoriesEntity>)

    @Insert
    suspend fun insertAllMenu(listMenu: List<MenuEntity>)
}
