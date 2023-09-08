package com.cyberkyubi.data.entity.middle_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

import com.cyberkyubi.data.entity.lower_level.MenuEntity

@Entity(
    tableName = "drinks",
    indices = [Index("drink_id"), Index("menu_id")],
    foreignKeys = [
        ForeignKey(
            entity = MenuEntity::class,
            parentColumns = ["menu_id"],
            childColumns = ["menu_id"]
        )
    ]
)
data class DrinksEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "drink_id") val drinkId: Int,
    @ColumnInfo(name = "menu_id") val menuId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "drawable_resource_name") val drawableResourceName: String
)

data class DrinkDataModel(
    @ColumnInfo(name = "drink_id") val drinkId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "drawable_resource_name") val drawableResourceName: String,
    @ColumnInfo(name = "ingredients_id") val ingredientsId: String
)