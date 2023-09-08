package com.cyberkyubi.data.dao

import androidx.room.Dao
import androidx.room.Query

import com.cyberkyubi.data.entity.lower_level.CategoriesEntity
import com.cyberkyubi.data.entity.lower_level.MenuDataModel
import com.cyberkyubi.data.entity.lower_level.MenuDetailsDataModel
import com.cyberkyubi.data.entity.middle_level.DrinkDataModel
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

    @Query("""
        select 
            d.drink_id, 
            d.name,
            dp.price,
            d.drawable_resource_name, 
            group_concat(di.ingredient_id, ', ') as ingredients_id
        FROM 
            drinks AS d 
        JOIN 
            drink_ingredients AS di ON d.drink_id = di.drink_id 
		JOIN 
			drink_prices AS dp ON d.drink_id = dp.drink_id
        WHERE 
            menu_id = :menuId AND is_default = 1
        GROUP by 
            d.drink_id
            """)
    suspend fun getDrinksListByMenuId(menuId: Int): List<DrinkDataModel>

    @Query("SELECT food_id, menu_id, name, drawable_resource_name FROM foods WHERE menu_id = :menuId")
    suspend fun getFoodMenuById(menuId: Int): List<FoodsEntity>
}
