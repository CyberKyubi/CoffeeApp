package com.cyberkyubi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.cyberkyubi.data.entity.lower_level.CategoriesEntity
import com.cyberkyubi.data.entity.lower_level.MenuEntity
import com.cyberkyubi.data.entity.middle_level.DrinksEntity
import com.cyberkyubi.data.entity.middle_level.FoodsEntity

@Dao
interface CoffeeDao {

    @Query("SELECT category_id, title FROM categories")
    suspend fun getCategories(): List<CategoriesEntity>

    @Query("SELECT menu_id, title, category_id, drawable_resource_name, is_seasonal_specials FROM menu WHERE category_id = :categoryId")
    suspend fun getMenuByCategoryId(categoryId: Int): List<MenuEntity>

    @Query("SELECT drink_id, menu_id, name, drawable_resource_name FROM drinks WHERE menu_id = :menuId")
    suspend fun getDrinkMenuById(menuId: Int): List<DrinksEntity>

    @Query("SELECT food_id, menu_id, name, drawable_resource_name FROM foods WHERE menu_id = :menuId")
    suspend fun getFoodMenuById(menuId: Int): List<FoodsEntity>
}
