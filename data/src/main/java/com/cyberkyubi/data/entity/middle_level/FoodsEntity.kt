package com.cyberkyubi.data.entity.middle_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

import com.cyberkyubi.data.entity.lower_level.MenuEntity

@Entity(
    tableName = "foods",
    indices = [Index("food_id"), Index("menu_id")],
    foreignKeys = [
        ForeignKey(
            entity = MenuEntity::class,
            parentColumns = ["menu_id"],
            childColumns = ["menu_id"]
        )
    ]
)
data class FoodsEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "food_id") val foodId: Int,
    @ColumnInfo(name = "menu_id") val menuId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "drawable_resource_name") val drawableResourceName: String
)