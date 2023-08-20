package com.cyberkyubi.data.entity.top_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.cyberkyubi.data.entity.middle_level.DrinksEntity

@Entity(
    tableName = "drink_prices",
    indices = [Index("drink_price_id",), Index("drink_id"), Index("drink_size_id"), Index("drink_milk_id")],
    foreignKeys = [
        ForeignKey(
            entity = DrinksEntity::class,
            parentColumns = ["drink_id"],
            childColumns = ["drink_id"]
        ),
        ForeignKey(
            entity = DrinkSizesEntity::class,
            parentColumns = ["drink_size_id"],
            childColumns = ["drink_size_id"]
        ),
        ForeignKey(
            entity = DrinkMilksEntity::class,
            parentColumns = ["drink_milk_id"],
            childColumns = ["drink_milk_id"]
        )
    ]
)
data class DrinkPricesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "drink_price_id") val drinkPriceId: Int,
    @ColumnInfo(name = "drink_id") val drinkId: Int,
    @ColumnInfo(name = "drink_size_id") val drinkSizeId: Int,
    @ColumnInfo(name = "drink_milk_id") val drinkMilkId: Int,
    @ColumnInfo(name = "price") val price: Long,
    @ColumnInfo(name = "is_default") val isDefault: Boolean = false
)
