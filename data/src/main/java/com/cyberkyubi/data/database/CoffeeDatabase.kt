package com.cyberkyubi.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cyberkyubi.data.dao.CoffeeDao

import com.cyberkyubi.data.entity.lower_level.CategoriesEntity
import com.cyberkyubi.data.entity.lower_level.MenuEntity
import com.cyberkyubi.data.entity.middle_level.DrinksEntity
import com.cyberkyubi.data.entity.middle_level.FoodsEntity

@Database(
    version = 1,
    entities = [
        CategoriesEntity::class,
        MenuEntity::class,

        DrinksEntity::class,
        FoodsEntity::class
    ]
)
abstract class CoffeeDatabase: RoomDatabase() {

    abstract fun getCoffeeDao(): CoffeeDao
}