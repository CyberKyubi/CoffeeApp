package com.cyberkyubi.data.entity.top_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "sizes",
    indices = [Index("size_id")]
)
data class SizesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "size_id") val sizeId: Int,
    @ColumnInfo(name = "size_type") val sizeType: String
)

