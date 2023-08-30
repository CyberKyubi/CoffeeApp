package com.cyberkyubi.data.entity.lower_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "menu",
    indices = [Index("menu_id"), Index("category_id")],
    foreignKeys = [
        ForeignKey(
            entity = CategoriesEntity::class,
            parentColumns = ["category_id"],
            childColumns = ["category_id"]
        )
    ]
)
data class MenuEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "menu_id") val menuId: Int,
    @ColumnInfo(name = "category_id") val categoryId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "is_seasonal_specials") val isSeasonalSpecials: String,
    @ColumnInfo(name = "drawable_resource_name") val drawableResourceName: String
)