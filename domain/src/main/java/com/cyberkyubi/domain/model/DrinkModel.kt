package com.cyberkyubi.domain.model

data class DrinkModel (
    val drinkId: Int,
    val name: String,
    val price: Int,
    val drawableResourceName: String,
    var ingredients: List<Int>
)