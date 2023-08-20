package com.cyberkyubi.data.entity.top_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

import com.cyberkyubi.data.entity.middle_level.DrinksEntity

@Entity(
    tableName = "drink_milks",
    indices = [Index("drink_milk_id"), Index("drink_id"), Index("milk_id")],
    foreignKeys = [
        ForeignKey(
            entity = DrinksEntity::class,
            parentColumns = ["drink_id"],
            childColumns = ["drink_id"]
        ),
        ForeignKey(
            entity = MilksEntity::class,
            parentColumns = ["milk_id"],
            childColumns = ["milk_id"]
        )
    ]
)
data class DrinkMilksEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "drink_milk_id") val drinkMilkId: Int,
    @ColumnInfo(name = "drink_id") val drinkId: Int,
    @ColumnInfo(name = "milk_id") val milkId: Int
)