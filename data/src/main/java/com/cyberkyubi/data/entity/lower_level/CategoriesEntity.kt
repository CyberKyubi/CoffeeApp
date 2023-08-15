package com.cyberkyubi.data.entity.lower_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "categories",
    indices = [Index("category_id")],
)
data class CategoriesEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "category_id") val categoryId: Int,
    @ColumnInfo(name = "title") val title: String
)