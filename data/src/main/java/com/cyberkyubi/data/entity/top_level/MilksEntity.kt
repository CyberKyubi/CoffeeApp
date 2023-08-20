package com.cyberkyubi.data.entity.top_level

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "milks",
    indices = [Index("milk_id")]
)
data class MilksEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "milk_id") val milkId: Int,
    @ColumnInfo(name = "milk_type") val milkType: String
)

