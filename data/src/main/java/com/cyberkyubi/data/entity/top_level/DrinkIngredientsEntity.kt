package com.cyberkyubi.data.entity.top_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

import com.cyberkyubi.data.entity.middle_level.DrinksEntity

@Entity(
    tableName = "drink_ingredients",
    indices = [Index("drink_id"), Index("ingredient_id")],
    foreignKeys = [
        ForeignKey(
            entity = DrinksEntity::class,
            parentColumns = ["drink_id"],
            childColumns = ["drink_id"]
        ),
        ForeignKey(
            entity = IngredientsEntity::class,
            parentColumns = ["ingredient_id"],
            childColumns = ["ingredient_id"]
        )
    ]
)
data class DrinkIngredientsEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "drink_ingredient_id") val drinkIngredientId: Int,
    @ColumnInfo(name = "drink_id") val drinkId: Int,
    @ColumnInfo(name = "ingredient_id") val ingredientId: Int,
)