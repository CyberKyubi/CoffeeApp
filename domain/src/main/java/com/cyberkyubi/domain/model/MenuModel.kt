package com.cyberkyubi.domain.model

data class MenuModel (
    val menuId: Int,
    val categoryId: Int,
    val title: String,
    val isSeasonalSpecials: Boolean,
    val drawableResourceName: String
)

data class MenuDetailsModel(
    val menuId: Int,
    val title: String,
    val description: String
)