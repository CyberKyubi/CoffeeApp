package com.cyberkyubi.domain.usecase

import com.cyberkyubi.domain.model.CardOfProductMenuModel

class GetFoodMenuUseCase {

    fun execute(): List<CardOfProductMenuModel> {
        return listOf(
            CardOfProductMenuModel(title = "Каши"),
            CardOfProductMenuModel(title = "Десерты"),
            CardOfProductMenuModel(title = "Сендвичи"),
        )
    }
}