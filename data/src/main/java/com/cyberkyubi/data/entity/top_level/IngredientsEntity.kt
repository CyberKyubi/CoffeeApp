package com.cyberkyubi.data.entity.top_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "ingredients",
    indices = [Index("ingredient_id")]
)
data class IngredientsEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ingredient_id") val ingredientId: Int,
    @ColumnInfo(name = "ingredient_name") val ingredientName: String
)