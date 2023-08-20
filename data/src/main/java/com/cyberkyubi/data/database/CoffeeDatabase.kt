package com.cyberkyubi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

import com.cyberkyubi.data.dao.CoffeeDao
import com.cyberkyubi.data.entity.lower_level.CategoriesEntity
import com.cyberkyubi.data.entity.lower_level.MenuEntity
import com.cyberkyubi.data.entity.middle_level.DrinksEntity
import com.cyberkyubi.data.entity.middle_level.FoodsEntity
import com.cyberkyubi.data.entity.top_level.DrinkMilksEntity
import com.cyberkyubi.data.entity.top_level.DrinkPricesEntity
import com.cyberkyubi.data.entity.top_level.DrinkSizesEntity
import com.cyberkyubi.data.entity.top_level.MilksEntity
import com.cyberkyubi.data.entity.top_level.SizesEntity

@Database(
    version = 1,
    entities = [
        CategoriesEntity::class,
        MenuEntity::class,

        DrinksEntity::class,
        FoodsEntity::class,

        MilksEntity::class,
        SizesEntity::class,
        DrinkSizesEntity::class,
        DrinkMilksEntity::class,
        DrinkPricesEntity::class
    ]
)
abstract class CoffeeDatabase: RoomDatabase() {

    abstract fun getCoffeeDao(): CoffeeDao
}