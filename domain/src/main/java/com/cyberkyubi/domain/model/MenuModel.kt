package com.cyberkyubi.domain.model

data class MenuModel (
    val menuId: Int,
    val categoryId: Int,
    val title: String,
    val description: String,
    val isSeasonalSpecials: String,
    val drawableResourceName: String
)
