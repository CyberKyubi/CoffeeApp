package com.cyberkyubi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.cyberkyubi.data.entity.lower_level.CategoriesEntity
import com.cyberkyubi.data.entity.lower_level.MenuDataModel
import com.cyberkyubi.data.entity.lower_level.MenuDetailsDataModel
import com.cyberkyubi.data.entity.lower_level.MenuEntity
import com.cyberkyubi.data.entity.middle_level.DrinksEntity
import com.cyberkyubi.data.entity.middle_level.FoodsEntity

@Dao
interface CoffeeDao {

    @Query("SELECT category_id, title FROM categories")
    suspend fun getCategories(): List<CategoriesEntity>

    @Query("SELECT menu_id, category_id, title, is_seasonal_specials, drawable_resource_name FROM menu WHERE category_id = :categoryId")
    suspend fun getMenuByCategoryId(categoryId: Int): List<MenuDataModel>

    @Query("SELECT menu_id, title, description FROM menu WHERE menu_id = :menuId")
    suspend fun getMenuDetailsById(menuId: Int): MenuDetailsDataModel

    @Query("SELECT drink_id, menu_id, name, drawable_resource_name FROM drinks WHERE menu_id = :menuId")
    suspend fun getDrinkMenuById(menuId: Int): List<DrinksEntity>

    @Query("SELECT food_id, menu_id, name, drawable_resource_name FROM foods WHERE menu_id = :menuId")
    suspend fun getFoodMenuById(menuId: Int): List<FoodsEntity>
}
