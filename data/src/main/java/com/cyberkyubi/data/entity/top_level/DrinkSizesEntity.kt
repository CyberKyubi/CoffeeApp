package com.cyberkyubi.data.entity.top_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

import com.cyberkyubi.data.entity.middle_level.DrinksEntity


@Entity(
    tableName = "drink_sizes",
    indices = [Index("drink_size_id"), Index("drink_id"), Index("size_id")],
    foreignKeys = [
        ForeignKey(
            entity = DrinksEntity::class,
            parentColumns = ["drink_id"],
            childColumns = ["drink_id"]
        ),
        ForeignKey(
            entity = SizesEntity::class,
            parentColumns = ["size_id"],
            childColumns = ["size_id"]
        )
    ]
)
data class DrinkSizesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "drink_size_id") val drinkSizeId: Int,
    @ColumnInfo(name = "drink_id") val drinkId: Int,
    @ColumnInfo(name = "size_id") val sizeId: Int
)

